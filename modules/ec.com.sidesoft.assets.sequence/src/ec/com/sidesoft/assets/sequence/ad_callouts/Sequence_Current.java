package ec.com.sidesoft.assets.sequence.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
import com.sidesoft.ecuador.asset.subcategory.level.SSASLSubcategory;


public class Sequence_Current extends SimpleCallout {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    
	String strChanged = info.getStringParameter("inpLastFieldChanged", null);
  String subcategoryId = info.getStringParameter("inpemSsaslSubcategoryId", null);
  String categoryId = info.getStringParameter("inpaAssetGroupId", null);
  String assetType = info.getStringParameter("inpemSsamAssettype", null);
  String valueIdentifier = info.getStringParameter("inpvalue", null);
  String assetId = info.getStringParameter("inpaAssetId", null);
  String category = null;
  String sub_Category = null;
  String current_Value = null;
  String old_Value = null;

    final SSASLSubcategory subCategory = OBDal.getInstance().get(SSASLSubcategory.class, subcategoryId);
    Asset asset = OBDal.getInstance().get(Asset.class, assetId);

    if(assetType.equals("AA")|| assetType.equals("SSCMU_AAC")){
      category = subCategory.getAssetCategory().getSsaseqSeqPrefixPe();
      sub_Category = subCategory.getSsaseqSequencePrefixPe();
      if(subCategory.getSsaseqCurrentValuePe()!= null){
        current_Value = String.format("%05d",subCategory.getSsaseqCurrentValuePe());
        old_Value = String.format("%05d",subCategory.getSsaseqCurrentValuePe()- 1);
        }
      else {
        subCategory.setSsaseqCurrentValuePe(Long.valueOf("0"));
        OBDal.getInstance().save(subCategory);
        OBDal.getInstance().flush();
        current_Value = String.format("%05d",subCategory.getSsaseqCurrentValuePe());
        }
    }
    else{
      category = subCategory.getAssetCategory().getSsaseqSequencePrefix();
      sub_Category = subCategory.getSsaseqSequencePrefix(); 
      if(subCategory.getSsaseqCurrentValue()!= null){
        current_Value = String.format("%05d",subCategory.getSsaseqCurrentValue());
        old_Value = String.format("%05d",subCategory.getSsaseqCurrentValue()- 1);
        }
      else {
        subCategory.setSsaseqCurrentValue(Long.valueOf("0"));
        OBDal.getInstance().save(subCategory);
        OBDal.getInstance().flush();
        current_Value = String.format("%05d",subCategory.getSsaseqCurrentValue());
        }
    }

    // Valida que exista una categoria y una subcategoria
    if(asset==null){
          if(category != null & sub_Category != null ){ 
                  // Comprueba si la subcategoria es la misma
            info.addResult("inpvalue",category+sub_Category+current_Value);
          }
          else {
            info.addResult("inpvalue", "");
          }
    }
        else if(asset!=null & asset.getSearchKey().equals(category+sub_Category+old_Value)){ 
        info.addResult("inpvalue",asset.getSearchKey() );
    } 
    else {
          if(category != null & sub_Category != null ){ 
                  // Comprueba si la subcategoria es la misma
            info.addResult("inpvalue",category+sub_Category+current_Value);
          }
          else {
            info.addResult("inpvalue", "");
          }    
        }
  }
}