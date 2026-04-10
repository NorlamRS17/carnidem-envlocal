package ec.com.sidesoft.user.advanced.security.utility;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBDal;
import org.openbravo.service.password.PasswordStrengthChecker;

import ec.com.sidesoft.user.advanced.security.SsuasSecurityConfig;

@Alternative
@ApplicationScoped
public class CustomPasswordStrengthChecker extends PasswordStrengthChecker {

  private static final int DEFAULT_MINIMUM_LENGTH = 8;
  private static final int MIN_REQUIRED_CRITERIA = 3;

  private List<PasswordStrengthCriterion> strengthCriteria;

  @PostConstruct
  private void init() {
    strengthCriteria = new ArrayList<>(4);
    strengthCriteria.add(getUppercaseCriterion());
    strengthCriteria.add(getLowercaseCriterion());
    strengthCriteria.add(getDigitsCriterion());
    strengthCriteria.add(getSpecialCharactersCriterion());
  }

  @Override
  public boolean isStrongPassword(String password) {
    return hasMinimumLength(password) && (getCriteriaScore(password) >= MIN_REQUIRED_CRITERIA);
  }

  private int getCriteriaScore(String password) {
    int score = 0;
    for (PasswordStrengthCriterion criterion : strengthCriteria) {
      if (criterion.match(password)) {
        score++;
      }
    }
    return score;
  }

  private boolean hasMinimumLength(String password) {
    int minLength = getConfiguredMinLength();
    return password.length() >= minLength;
  }

  private int getConfiguredMinLength() {
    try {
      List<SsuasSecurityConfig> configList = OBDal.getInstance()
          .createCriteria(SsuasSecurityConfig.class)
          .add(Restrictions.eq(SsuasSecurityConfig.PROPERTY_ACTIVE, true))
          .add(Restrictions.eq(SsuasSecurityConfig.PROPERTY_PASSWORDCOMPLEXITY, "AD"))
          .setMaxResults(1)
          .list();

      if (!configList.isEmpty()) {
        SsuasSecurityConfig config = configList.get(0);
        Long value = config.getPasswordLength();

        if (value != null && value > 0) {
          return value.intValue();
        }
      }
    } catch (Exception e) {

    }

    return DEFAULT_MINIMUM_LENGTH;
  }

  private PasswordStrengthCriterion getUppercaseCriterion() {
    return new PasswordStrengthCriterion() {
      @Override
      public boolean match(String password) {
        return password.matches(".*[A-Z].*");
      }
    };
  }

  private PasswordStrengthCriterion getLowercaseCriterion() {
    return new PasswordStrengthCriterion() {
      @Override
      public boolean match(String password) {
        return password.matches(".*[a-z].*");
      }
    };
  }

  private PasswordStrengthCriterion getDigitsCriterion() {
    return new PasswordStrengthCriterion() {
      @Override
      public boolean match(String password) {
        return password.matches(".*[0-9].*");
      }
    };
  }

  private PasswordStrengthCriterion getSpecialCharactersCriterion() {
    return new PasswordStrengthCriterion() {
      @Override
      public boolean match(String password) {
        return password.matches(".*[`~!@#$%€^&*()_\\-+={}\\[\\]|:;\"' <>,.?/].*");
      }
    };
  }

  private interface PasswordStrengthCriterion {
    boolean match(String password);
  }

}
