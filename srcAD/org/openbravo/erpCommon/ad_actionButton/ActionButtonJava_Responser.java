
package org.openbravo.erpCommon.ad_actionButton;


import org.openbravo.erpCommon.utility.*;
import org.openbravo.erpCommon.reference.*;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.database.SessionInfo;
import org.openbravo.erpCommon.obps.ActivationKey;
import org.openbravo.erpCommon.obps.ActivationKey.FeatureRestriction;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.ui.Process;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;

@SuppressWarnings("unused")
public class ActionButtonJava_Responser extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  protected static final String windowId = "ActionButtonResponser";
  
  public void init (ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strProcessId = getProcessId(vars);

    // set process type and id for audit
    SessionInfo.setProcessType("P");
    SessionInfo.setProcessId(strProcessId);
    SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
    SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
    SessionInfo.setQueryProfile("manualProcess");

    try {
      OBContext.setAdminMode();
      Process process = OBDal.getInstance().get(Process.class, strProcessId);
      if (process != null) {
        SessionInfo.setModuleId(process.getModule().getId());
      }
    } finally {
      OBContext.restorePreviousMode();
    }
    super.service(request, response);
  }

  private String getProcessId(VariablesSecureApp vars) throws ServletException {
    String command = vars.getCommand();
    if (command.equals("DEFAULT")) {
      return vars.getRequiredStringParameter("inpadProcessId");
    } else if (command.startsWith("BUTTON")) {
      return command.substring("BUTTON".length());
    } else if (command.startsWith("FRAMES")) {
      return command.substring("FRAMES".length());
    } else if (command.startsWith("SAVE_BUTTONActionButton")) {
      return command.substring("SAVE_BUTTONActionButton".length());
    }
    return null;
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strProcessId = getProcessId(vars);
    
    if (vars.getCommand().startsWith("FRAMES")) {
      printPageFrames(response, vars, strProcessId);
    }
   
    if (!vars.commandIn("DEFAULT")) {
      //Check access
      FeatureRestriction featureRestriction = ActivationKey.getInstance().hasLicenseAccess("P",
          strProcessId);
      if (featureRestriction != FeatureRestriction.NO_RESTRICTION) {
        licenseError("P", strProcessId, featureRestriction, response, request, vars, true);
      }
      if (!hasGeneralAccess(vars, "P", strProcessId)) {
        bdErrorGeneralPopUp(request, response,
            Utility.messageBD(this, "Error", vars.getLanguage()), Utility.messageBD(this,
                "AccessTableNoView", vars.getLanguage()));
      }
    }
    
      
    if (vars.commandIn("DEFAULT")) {
      printPageDefault(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9DB4D30BFC5144B9B431CB49DDE9270D")) {
        
        printPageButton9DB4D30BFC5144B9B431CB49DDE9270D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        
        printPageButton7CB6B4D1ECCF4036B3F111D2CF11AADE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON970EAD9B846648A7AB1F0CCA5058356C")) {
        
        printPageButton970EAD9B846648A7AB1F0CCA5058356C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7EDBFEC35BDA4FF4AF05ED516CDAFB90")) {
        
        printPageButton7EDBFEC35BDA4FF4AF05ED516CDAFB90(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONABDFC8131D964936AD2EF7E0CED97FD9")) {
        
        printPageButtonABDFC8131D964936AD2EF7E0CED97FD9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3C386BC12832466790E50F2F8C5EBD85")) {
        
        printPageButton3C386BC12832466790E50F2F8C5EBD85(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONEFDBF909811544DAAE4E876AA781E5DC")) {
        
        printPageButtonEFDBF909811544DAAE4E876AA781E5DC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON107")) {
        
        printPageButton107(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCD7283DF804B449C97DA09446669EEEF")) {
        
        printPageButtonCD7283DF804B449C97DA09446669EEEF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON85601427EAEE401FA0250FF0A6DD62EF")) {
        
        printPageButton85601427EAEE401FA0250FF0A6DD62EF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONA3FE1F9892394386A49FB707AA50A0FA")) {
        
        printPageButtonA3FE1F9892394386A49FB707AA50A0FA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON136")) {
        
        printPageButton136(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFB740AB61B0E42B198D2C88D3A0D0CE6")) {
        
        printPageButtonFB740AB61B0E42B198D2C88D3A0D0CE6(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON58591E3E0F7648E4A09058E037CE49FC")) {
        
        printPageButton58591E3E0F7648E4A09058E037CE49FC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON64B3FF29AC174F4B94538BD0A3CE1CD3")) {
        
        printPageButton64B3FF29AC174F4B94538BD0A3CE1CD3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON23D1B163EC0B41F790CE39BF01DA320E")) {
        
        printPageButton23D1B163EC0B41F790CE39BF01DA320E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9EB2228A60684C0DBEC12D5CD8D85218")) {
        
        printPageButton9EB2228A60684C0DBEC12D5CD8D85218(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND85D5B5E368A49B1A6293BA4AE15F0F9")) {
        
        printPageButtonD85D5B5E368A49B1A6293BA4AE15F0F9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF80808133362F6A013336781FCE0066")) {
        
        printPageButtonFF80808133362F6A013336781FCE0066(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF8081813219E68E013219ECFE930004")) {
        
        printPageButtonFF8081813219E68E013219ECFE930004(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF808181324D007801324D2AE1130066")) {
        
        printPageButtonFF808181324D007801324D2AE1130066(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF808181326CD80501326CE906D70042")) {
        
        printPageButtonFF808181326CD80501326CE906D70042(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF80818132A4F6AD0132A573DD7A0021")) {
        
        printPageButtonFF80818132A4F6AD0132A573DD7A0021(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON2DDE7D3618034C38A4462B7F3456C28D")) {
        
        printPageButton2DDE7D3618034C38A4462B7F3456C28D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6BF16EFC772843AC9A17552AE0B26AB7")) {
        
        printPageButton6BF16EFC772843AC9A17552AE0B26AB7(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0BDC2164ED3E48539FCEF4D306F29EFD")) {
        
        printPageButton0BDC2164ED3E48539FCEF4D306F29EFD(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5BE14AA10165490A9ADEFB7532F7FA94")) {
        
        printPageButton5BE14AA10165490A9ADEFB7532F7FA94(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON58A9261BACEF45DDA526F29D8557272D")) {
        
        printPageButton58A9261BACEF45DDA526F29D8557272D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON15C8708DFC464C2D91286E59624FDD18")) {
        
        printPageButton15C8708DFC464C2D91286E59624FDD18(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON017312F51139438A9665775E3B5392A1")) {
        
        printPageButton017312F51139438A9665775E3B5392A1(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6255BE488882480599C81284B70CD9B3")) {
        
        printPageButton6255BE488882480599C81284B70CD9B3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF68F2890E96D4D85A1DEF0274D105BCE")) {
        
        printPageButtonF68F2890E96D4D85A1DEF0274D105BCE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON29D17F515727436DBCE32BC6CA28382B")) {
        
        printPageButton29D17F515727436DBCE32BC6CA28382B(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDE1B382FDD2540199D223586F6E216D0")) {
        
        printPageButtonDE1B382FDD2540199D223586F6E216D0(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND16966FBF9604A3D91A50DC83C6EA8E3")) {
        
        printPageButtonD16966FBF9604A3D91A50DC83C6EA8E3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF8080812E2F8EAE012E2F94CF470014")) {
        
        printPageButtonFF8080812E2F8EAE012E2F94CF470014(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF8080812F348A97012F349DC24F0007")) {
        
        printPageButtonFF8080812F348A97012F349DC24F0007(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON66912CD2D96B494FA23F4AF2B7F795BA")) {
        
        printPageButton66912CD2D96B494FA23F4AF2B7F795BA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONBED3CF78244147038E632AC2700C4F22")) {
        
        printPageButtonBED3CF78244147038E632AC2700C4F22(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON4380C4EBA98A4E7EB784ABC1360FE8EA")) {
        
        printPageButton4380C4EBA98A4E7EB784ABC1360FE8EA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON8388633AADD04FC487A0AEA775448333")) {
        
        printPageButton8388633AADD04FC487A0AEA775448333(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND10230FC59154A12ABC9FA6B4A9E4080")) {
        
        printPageButtonD10230FC59154A12ABC9FA6B4A9E4080(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9E930637C9B44A73B0227D49AA30DD12")) {
        
        printPageButton9E930637C9B44A73B0227D49AA30DD12(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON71146C7A96774E58A772B98A8B1C6953")) {
        
        printPageButton71146C7A96774E58A772B98A8B1C6953(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCD35DC8F54624AC0948C891C7F7E70A1")) {
        
        printPageButtonCD35DC8F54624AC0948C891C7F7E70A1(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3B45D448EACA44FF9BD084C302459014")) {
        
        printPageButton3B45D448EACA44FF9BD084C302459014(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3FAE7B1AB61F4E61B67481247AE8215F")) {
        
        printPageButton3FAE7B1AB61F4E61B67481247AE8215F(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0AF06FA75CC348D98ECBD5FFFEF79330")) {
        
        printPageButton0AF06FA75CC348D98ECBD5FFFEF79330(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON4FB68828FA684DAAA1478926ED32B84C")) {
        
        printPageButton4FB68828FA684DAAA1478926ED32B84C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON21C4B0035C5645109223814F0DD91AB5")) {
        
        printPageButton21C4B0035C5645109223814F0DD91AB5(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0D9C391058AC4367BCC71DA7D39DE4C3")) {
        
        printPageButton0D9C391058AC4367BCC71DA7D39DE4C3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON418D9416C62B4087BE59A1B358910954")) {
        
        printPageButton418D9416C62B4087BE59A1B358910954(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON837888BA221D47E6915FDE6DD361C1D9")) {
        
        printPageButton837888BA221D47E6915FDE6DD361C1D9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON72380902AAEC47B4A493717B4D504E9E")) {
        
        printPageButton72380902AAEC47B4A493717B4D504E9E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7CC8083871A2456BAC7B948F3510BC3C")) {
        
        printPageButton7CC8083871A2456BAC7B948F3510BC3C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON39774700D5B041BEB5DCC4CFF9E16CBE")) {
        
        printPageButton39774700D5B041BEB5DCC4CFF9E16CBE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON437B1EE180984960A698FB8154DE5D35")) {
        
        printPageButton437B1EE180984960A698FB8154DE5D35(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDD60049F200E490BA823A5B3532F57B4")) {
        
        printPageButtonDD60049F200E490BA823A5B3532F57B4(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON05E6E7C50BE3447392C9BC02EB86500D")) {
        
        printPageButton05E6E7C50BE3447392C9BC02EB86500D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON98EC8B6FBAC145CA926C4740A2C2B6FF")) {
        
        printPageButton98EC8B6FBAC145CA926C4740A2C2B6FF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9337D1CEEC0647B888EC257259F025B2")) {
        
        printPageButton9337D1CEEC0647B888EC257259F025B2(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND93CCE4D4D954542BD7AA2F107404BAD")) {
        
        printPageButtonD93CCE4D4D954542BD7AA2F107404BAD(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND4F242B223A947238DEC0C1727C29D7B")) {
        
        printPageButtonD4F242B223A947238DEC0C1727C29D7B(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON177A8D600E334A188E193EC8C647AED0")) {
        
        printPageButton177A8D600E334A188E193EC8C647AED0(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6F5F5FCC3C124629A02179A1D55DB636")) {
        
        printPageButton6F5F5FCC3C124629A02179A1D55DB636(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3A53E5B4438A432EA7F48FD4A4FB9992")) {
        
        printPageButton3A53E5B4438A432EA7F48FD4A4FB9992(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONED5960492A2C41929D59442D2C38F174")) {
        
        printPageButtonED5960492A2C41929D59442D2C38F174(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON8483E826BD4A4F4FABE988B7EE7193EC")) {
        
        printPageButton8483E826BD4A4F4FABE988B7EE7193EC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF57CB7A61C8F47E3AE2F19B740C2B72C")) {
        
        printPageButtonF57CB7A61C8F47E3AE2F19B740C2B72C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON36F2D08523FE4E4C9A8B8000CDEF2A39")) {
        
        printPageButton36F2D08523FE4E4C9A8B8000CDEF2A39(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON50A6708720CB4B7D9A62222AAFF04579")) {
        
        printPageButton50A6708720CB4B7D9A62222AAFF04579(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF5B1A584BF824E3FAC430E032F020F4E")) {
        
        printPageButtonF5B1A584BF824E3FAC430E032F020F4E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON364164C3FDC54156936DD179969F46B6")) {
        
        printPageButton364164C3FDC54156936DD179969F46B6(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON1BBCF97310864568BE34873F36850CC9")) {
        
        printPageButton1BBCF97310864568BE34873F36850CC9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCF5B8CCBDB3B46978A3A202D742E323D")) {
        
        printPageButtonCF5B8CCBDB3B46978A3A202D742E323D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON93A46131F08141FA81C13B9D82A1F80C")) {
        
        printPageButton93A46131F08141FA81C13B9D82A1F80C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5CF52155581B47CAAF5601D5C5DA93B3")) {
        
        printPageButton5CF52155581B47CAAF5601D5C5DA93B3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON00052E7428F8477CAACCE14830F8F43E")) {
        
        printPageButton00052E7428F8477CAACCE14830F8F43E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON01DA33DE7D4B443A8CBF5867B6B1C6C6")) {
        
        printPageButton01DA33DE7D4B443A8CBF5867B6B1C6C6(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND244C9919E6747AD9DF9B43D1E1C6233")) {
        
        printPageButtonD244C9919E6747AD9DF9B43D1E1C6233(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0C26D138283A4702AE8657D0B2755511")) {
        
        printPageButton0C26D138283A4702AE8657D0B2755511(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON1B5C7B74144344F7BF8154C73891E1F7")) {
        
        printPageButton1B5C7B74144344F7BF8154C73891E1F7(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON29604C7EF05B44C0AA36ACF4CF48528A")) {
        
        printPageButton29604C7EF05B44C0AA36ACF4CF48528A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONC59D80628EAC461CA227D7ABAD089FA0")) {
        
        printPageButtonC59D80628EAC461CA227D7ABAD089FA0(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONBBF5C85870774F0C89D1DCF8F7767F76")) {
        
        printPageButtonBBF5C85870774F0C89D1DCF8F7767F76(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6278DF8D5F1D4091967DDB1733EB7622")) {
        
        printPageButton6278DF8D5F1D4091967DDB1733EB7622(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON864EAE677EE747ABB219FC888F16B44E")) {
        
        printPageButton864EAE677EE747ABB219FC888F16B44E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON17A8F88150734A46AB11C3E5E3AEAC71")) {
        
        printPageButton17A8F88150734A46AB11C3E5E3AEAC71(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONAF99C0A0D75D490D80FEA24430E819FB")) {
        
        printPageButtonAF99C0A0D75D490D80FEA24430E819FB(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON60B20166BD984E8EBCB9ABCA90329BCA")) {
        
        printPageButton60B20166BD984E8EBCB9ABCA90329BCA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONA3D36D357A9F48DDB7507FCADC8465F3")) {
        
        printPageButtonA3D36D357A9F48DDB7507FCADC8465F3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON254354AEAC1645369FC71F81415993EB")) {
        
        printPageButton254354AEAC1645369FC71F81415993EB(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON75BDBA6366F349EB84D46C0443F8B398")) {
        
        printPageButton75BDBA6366F349EB84D46C0443F8B398(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6BCC36C351F24D5F8ED72999F1C28220")) {
        
        printPageButton6BCC36C351F24D5F8ED72999F1C28220(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF873EC6D50E44F878E9505AF20394AC0")) {
        
        printPageButtonF873EC6D50E44F878E9505AF20394AC0(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONAEC4E66A00274AEBBC4F1E61717A7C5F")) {
        
        printPageButtonAEC4E66A00274AEBBC4F1E61717A7C5F(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON00AB8AD197244C8EAA90B9D7A79ABCE4")) {
        
        printPageButton00AB8AD197244C8EAA90B9D7A79ABCE4(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON803D4F81300C464E96E2CB3F9854588B")) {
        
        printPageButton803D4F81300C464E96E2CB3F9854588B(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONC80B03ECDAE345F782E8A10493BCE2B8")) {
        
        printPageButtonC80B03ECDAE345F782E8A10493BCE2B8(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON33FAB6B9C73240B6829D03908C6CA448")) {
        
        printPageButton33FAB6B9C73240B6829D03908C6CA448(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONAF774550BCA74626ACBC6A9021EB1F88")) {
        
        printPageButtonAF774550BCA74626ACBC6A9021EB1F88(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONC14ACFDEF17E458E90AD6072C93D78D8")) {
        
        printPageButtonC14ACFDEF17E458E90AD6072C93D78D8(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON48D797375D1D421BB9F146AF8546E879")) {
        
        printPageButton48D797375D1D421BB9F146AF8546E879(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON943C8F5BEAAE44298C2572C727CF5614")) {
        
        printPageButton943C8F5BEAAE44298C2572C727CF5614(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9C4187630C0A44B3829B2A9120B3EBC8")) {
        
        printPageButton9C4187630C0A44B3829B2A9120B3EBC8(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7901FF7DF9444013904A03D8F86E1B7E")) {
        
        printPageButton7901FF7DF9444013904A03D8F86E1B7E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB0DCB2771D744EAA8F75B2B6530CABF8")) {
        
        printPageButtonB0DCB2771D744EAA8F75B2B6530CABF8(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB8E6E808CF5645669553E79F67936C5A")) {
        
        printPageButtonB8E6E808CF5645669553E79F67936C5A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONE0B23E3E8CEB4CD19E5EBC059E59ECBA")) {
        
        printPageButtonE0B23E3E8CEB4CD19E5EBC059E59ECBA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON164D2FFC9D184D7DA75085943AB657A5")) {
        
        printPageButton164D2FFC9D184D7DA75085943AB657A5(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF3D2D70E07914B0A9D2023D95EE4F5EA")) {
        
        printPageButtonF3D2D70E07914B0A9D2023D95EE4F5EA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND78F7B34CE624A778B8B064F96115122")) {
        
        printPageButtonD78F7B34CE624A778B8B064F96115122(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0483599196D442B0B7C4032DF3CD1496")) {
        
        printPageButton0483599196D442B0B7C4032DF3CD1496(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0A94232190EE46A2B4D13CBF30C8F423")) {
        
        printPageButton0A94232190EE46A2B4D13CBF30C8F423(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5192F005F0524EE1A59AD3DCA8CDF4A3")) {
        
        printPageButton5192F005F0524EE1A59AD3DCA8CDF4A3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONE74903303FE742EA93A4FA456DB444EC")) {
        
        printPageButtonE74903303FE742EA93A4FA456DB444EC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDBF26D81854746A19B1F2B1F0B4C0952")) {
        
        printPageButtonDBF26D81854746A19B1F2B1F0B4C0952(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCBD470CCB8274C60AB970DD9A8B9C9AD")) {
        
        printPageButtonCBD470CCB8274C60AB970DD9A8B9C9AD(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON1D22EE8C9F834A8E8051257DE39CBDB4")) {
        
        printPageButton1D22EE8C9F834A8E8051257DE39CBDB4(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF41B28D5D2294D9B930D6D2E0C38BAEF")) {
        
        printPageButtonF41B28D5D2294D9B930D6D2E0C38BAEF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONE1781F4CF87B4E898740D640FC454507")) {
        
        printPageButtonE1781F4CF87B4E898740D640FC454507(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONEF5BF59C53944CB6BBE5A6A4CACE7926")) {
        
        printPageButtonEF5BF59C53944CB6BBE5A6A4CACE7926(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONE18FC7C24D2647CE8F8BF88690E3A659")) {
        
        printPageButtonE18FC7C24D2647CE8F8BF88690E3A659(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONA37402A9673B4048A245E413D60263B9")) {
        
        printPageButtonA37402A9673B4048A245E413D60263B9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDFC1286B6CF8466F9E57A349A6BD6CA7")) {
        
        printPageButtonDFC1286B6CF8466F9E57A349A6BD6CA7(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONC2D00205D53E4D2290EB232FE78F3667")) {
        
        printPageButtonC2D00205D53E4D2290EB232FE78F3667(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB5C20B60DD3F4B4D93442FB7BE2DA6EA")) {
        
        printPageButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB88EEB979B6E4F92BAE22165681CA4AA")) {
        
        printPageButtonB88EEB979B6E4F92BAE22165681CA4AA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONBD3E529180454E6FAEC68F644CFF068A")) {
        
        printPageButtonBD3E529180454E6FAEC68F644CFF068A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON364900DC81134D3FBF819F85AFF5E7EA")) {
        
        printPageButton364900DC81134D3FBF819F85AFF5E7EA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9EB67D7B8AFA4BD9BBA09BDA63EAA271")) {
        
        printPageButton9EB67D7B8AFA4BD9BBA09BDA63EAA271(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON87FCB47E59564ED8AB7B2F927205A912")) {
        
        printPageButton87FCB47E59564ED8AB7B2F927205A912(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON77FC3840AB4A4814B8247BA69B484F87")) {
        
        printPageButton77FC3840AB4A4814B8247BA69B484F87(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND76FECE66C5748B1A30275734FFAFD5B")) {
        
        printPageButtonD76FECE66C5748B1A30275734FFAFD5B(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5DBC17C8408D4F878C4BD37962A7F9F8")) {
        
        printPageButton5DBC17C8408D4F878C4BD37962A7F9F8(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON8079F08464854BBEB4199DA1C0D7545C")) {
        
        printPageButton8079F08464854BBEB4199DA1C0D7545C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON2F09CAACE6E14C8FA56CE0ED4C7582B4")) {
        
        printPageButton2F09CAACE6E14C8FA56CE0ED4C7582B4(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5523CFE2A7A149DF894C9CDD4A18DB88")) {
        
        printPageButton5523CFE2A7A149DF894C9CDD4A18DB88(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDF4E2B745B914942866105844E4ECFFC")) {
        
        printPageButtonDF4E2B745B914942866105844E4ECFFC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFE7E37DEB4DF42F5853377E45E31A159")) {
        
        printPageButtonFE7E37DEB4DF42F5853377E45E31A159(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON1715C3DFAAD94C1B8628D881A6EBBCFF")) {
        
        printPageButton1715C3DFAAD94C1B8628D881A6EBBCFF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6FBD65B0FDB74D1AB07F0EADF18D48AE")) {
        
        printPageButton6FBD65B0FDB74D1AB07F0EADF18D48AE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON590066A49B89482786E6183DC0E99FE3")) {
        
        printPageButton590066A49B89482786E6183DC0E99FE3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCE81B27EADC74667A59506719E70349A")) {
        
        printPageButtonCE81B27EADC74667A59506719E70349A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON135AFAA691B4481D85C9D913E4331101")) {
        
        printPageButton135AFAA691B4481D85C9D913E4331101(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3D6ECD5657D645F4B82ABD5CC2A09BF3")) {
        
        printPageButton3D6ECD5657D645F4B82ABD5CC2A09BF3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON66C88DC622C14C8EA9272AFE367A01E6")) {
        
        printPageButton66C88DC622C14C8EA9272AFE367A01E6(response, vars, strProcessId);

    } else if (vars.commandIn("SAVE_BUTTONActionButton9DB4D30BFC5144B9B431CB49DDE9270D")) {
        process9DB4D30BFC5144B9B431CB49DDE9270D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        process7CB6B4D1ECCF4036B3F111D2CF11AADE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton970EAD9B846648A7AB1F0CCA5058356C")) {
        process970EAD9B846648A7AB1F0CCA5058356C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7EDBFEC35BDA4FF4AF05ED516CDAFB90")) {
        process7EDBFEC35BDA4FF4AF05ED516CDAFB90(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonABDFC8131D964936AD2EF7E0CED97FD9")) {
        processABDFC8131D964936AD2EF7E0CED97FD9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3C386BC12832466790E50F2F8C5EBD85")) {
        process3C386BC12832466790E50F2F8C5EBD85(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonEFDBF909811544DAAE4E876AA781E5DC")) {
        processEFDBF909811544DAAE4E876AA781E5DC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton107")) {
        process107(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCD7283DF804B449C97DA09446669EEEF")) {
        processCD7283DF804B449C97DA09446669EEEF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton85601427EAEE401FA0250FF0A6DD62EF")) {
        process85601427EAEE401FA0250FF0A6DD62EF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonA3FE1F9892394386A49FB707AA50A0FA")) {
        processA3FE1F9892394386A49FB707AA50A0FA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton136")) {
        process136(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFB740AB61B0E42B198D2C88D3A0D0CE6")) {
        processFB740AB61B0E42B198D2C88D3A0D0CE6(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton58591E3E0F7648E4A09058E037CE49FC")) {
        process58591E3E0F7648E4A09058E037CE49FC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton64B3FF29AC174F4B94538BD0A3CE1CD3")) {
        process64B3FF29AC174F4B94538BD0A3CE1CD3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton23D1B163EC0B41F790CE39BF01DA320E")) {
        process23D1B163EC0B41F790CE39BF01DA320E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9EB2228A60684C0DBEC12D5CD8D85218")) {
        process9EB2228A60684C0DBEC12D5CD8D85218(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD85D5B5E368A49B1A6293BA4AE15F0F9")) {
        processD85D5B5E368A49B1A6293BA4AE15F0F9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF80808133362F6A013336781FCE0066")) {
        processFF80808133362F6A013336781FCE0066(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF8081813219E68E013219ECFE930004")) {
        processFF8081813219E68E013219ECFE930004(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF808181324D007801324D2AE1130066")) {
        processFF808181324D007801324D2AE1130066(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF808181326CD80501326CE906D70042")) {
        processFF808181326CD80501326CE906D70042(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF80818132A4F6AD0132A573DD7A0021")) {
        processFF80818132A4F6AD0132A573DD7A0021(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton2DDE7D3618034C38A4462B7F3456C28D")) {
        process2DDE7D3618034C38A4462B7F3456C28D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6BF16EFC772843AC9A17552AE0B26AB7")) {
        process6BF16EFC772843AC9A17552AE0B26AB7(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0BDC2164ED3E48539FCEF4D306F29EFD")) {
        process0BDC2164ED3E48539FCEF4D306F29EFD(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5BE14AA10165490A9ADEFB7532F7FA94")) {
        process5BE14AA10165490A9ADEFB7532F7FA94(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton58A9261BACEF45DDA526F29D8557272D")) {
        process58A9261BACEF45DDA526F29D8557272D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton15C8708DFC464C2D91286E59624FDD18")) {
        process15C8708DFC464C2D91286E59624FDD18(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton017312F51139438A9665775E3B5392A1")) {
        process017312F51139438A9665775E3B5392A1(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6255BE488882480599C81284B70CD9B3")) {
        process6255BE488882480599C81284B70CD9B3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF68F2890E96D4D85A1DEF0274D105BCE")) {
        processF68F2890E96D4D85A1DEF0274D105BCE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton29D17F515727436DBCE32BC6CA28382B")) {
        process29D17F515727436DBCE32BC6CA28382B(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDE1B382FDD2540199D223586F6E216D0")) {
        processDE1B382FDD2540199D223586F6E216D0(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD16966FBF9604A3D91A50DC83C6EA8E3")) {
        processD16966FBF9604A3D91A50DC83C6EA8E3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF8080812E2F8EAE012E2F94CF470014")) {
        processFF8080812E2F8EAE012E2F94CF470014(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF8080812F348A97012F349DC24F0007")) {
        processFF8080812F348A97012F349DC24F0007(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton66912CD2D96B494FA23F4AF2B7F795BA")) {
        process66912CD2D96B494FA23F4AF2B7F795BA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonBED3CF78244147038E632AC2700C4F22")) {
        processBED3CF78244147038E632AC2700C4F22(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton4380C4EBA98A4E7EB784ABC1360FE8EA")) {
        process4380C4EBA98A4E7EB784ABC1360FE8EA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton8388633AADD04FC487A0AEA775448333")) {
        process8388633AADD04FC487A0AEA775448333(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD10230FC59154A12ABC9FA6B4A9E4080")) {
        processD10230FC59154A12ABC9FA6B4A9E4080(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9E930637C9B44A73B0227D49AA30DD12")) {
        process9E930637C9B44A73B0227D49AA30DD12(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton71146C7A96774E58A772B98A8B1C6953")) {
        process71146C7A96774E58A772B98A8B1C6953(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCD35DC8F54624AC0948C891C7F7E70A1")) {
        processCD35DC8F54624AC0948C891C7F7E70A1(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3B45D448EACA44FF9BD084C302459014")) {
        process3B45D448EACA44FF9BD084C302459014(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3FAE7B1AB61F4E61B67481247AE8215F")) {
        process3FAE7B1AB61F4E61B67481247AE8215F(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0AF06FA75CC348D98ECBD5FFFEF79330")) {
        process0AF06FA75CC348D98ECBD5FFFEF79330(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton4FB68828FA684DAAA1478926ED32B84C")) {
        process4FB68828FA684DAAA1478926ED32B84C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton21C4B0035C5645109223814F0DD91AB5")) {
        process21C4B0035C5645109223814F0DD91AB5(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0D9C391058AC4367BCC71DA7D39DE4C3")) {
        process0D9C391058AC4367BCC71DA7D39DE4C3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton418D9416C62B4087BE59A1B358910954")) {
        process418D9416C62B4087BE59A1B358910954(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton837888BA221D47E6915FDE6DD361C1D9")) {
        process837888BA221D47E6915FDE6DD361C1D9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton72380902AAEC47B4A493717B4D504E9E")) {
        process72380902AAEC47B4A493717B4D504E9E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7CC8083871A2456BAC7B948F3510BC3C")) {
        process7CC8083871A2456BAC7B948F3510BC3C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton39774700D5B041BEB5DCC4CFF9E16CBE")) {
        process39774700D5B041BEB5DCC4CFF9E16CBE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton437B1EE180984960A698FB8154DE5D35")) {
        process437B1EE180984960A698FB8154DE5D35(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDD60049F200E490BA823A5B3532F57B4")) {
        processDD60049F200E490BA823A5B3532F57B4(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton05E6E7C50BE3447392C9BC02EB86500D")) {
        process05E6E7C50BE3447392C9BC02EB86500D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton98EC8B6FBAC145CA926C4740A2C2B6FF")) {
        process98EC8B6FBAC145CA926C4740A2C2B6FF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9337D1CEEC0647B888EC257259F025B2")) {
        process9337D1CEEC0647B888EC257259F025B2(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD93CCE4D4D954542BD7AA2F107404BAD")) {
        processD93CCE4D4D954542BD7AA2F107404BAD(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD4F242B223A947238DEC0C1727C29D7B")) {
        processD4F242B223A947238DEC0C1727C29D7B(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton177A8D600E334A188E193EC8C647AED0")) {
        process177A8D600E334A188E193EC8C647AED0(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6F5F5FCC3C124629A02179A1D55DB636")) {
        process6F5F5FCC3C124629A02179A1D55DB636(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3A53E5B4438A432EA7F48FD4A4FB9992")) {
        process3A53E5B4438A432EA7F48FD4A4FB9992(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonED5960492A2C41929D59442D2C38F174")) {
        processED5960492A2C41929D59442D2C38F174(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton8483E826BD4A4F4FABE988B7EE7193EC")) {
        process8483E826BD4A4F4FABE988B7EE7193EC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF57CB7A61C8F47E3AE2F19B740C2B72C")) {
        processF57CB7A61C8F47E3AE2F19B740C2B72C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton36F2D08523FE4E4C9A8B8000CDEF2A39")) {
        process36F2D08523FE4E4C9A8B8000CDEF2A39(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton50A6708720CB4B7D9A62222AAFF04579")) {
        process50A6708720CB4B7D9A62222AAFF04579(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF5B1A584BF824E3FAC430E032F020F4E")) {
        processF5B1A584BF824E3FAC430E032F020F4E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton364164C3FDC54156936DD179969F46B6")) {
        process364164C3FDC54156936DD179969F46B6(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton1BBCF97310864568BE34873F36850CC9")) {
        process1BBCF97310864568BE34873F36850CC9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCF5B8CCBDB3B46978A3A202D742E323D")) {
        processCF5B8CCBDB3B46978A3A202D742E323D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton93A46131F08141FA81C13B9D82A1F80C")) {
        process93A46131F08141FA81C13B9D82A1F80C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5CF52155581B47CAAF5601D5C5DA93B3")) {
        process5CF52155581B47CAAF5601D5C5DA93B3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton00052E7428F8477CAACCE14830F8F43E")) {
        process00052E7428F8477CAACCE14830F8F43E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton01DA33DE7D4B443A8CBF5867B6B1C6C6")) {
        process01DA33DE7D4B443A8CBF5867B6B1C6C6(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD244C9919E6747AD9DF9B43D1E1C6233")) {
        processD244C9919E6747AD9DF9B43D1E1C6233(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0C26D138283A4702AE8657D0B2755511")) {
        process0C26D138283A4702AE8657D0B2755511(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton1B5C7B74144344F7BF8154C73891E1F7")) {
        process1B5C7B74144344F7BF8154C73891E1F7(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton29604C7EF05B44C0AA36ACF4CF48528A")) {
        process29604C7EF05B44C0AA36ACF4CF48528A(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonC59D80628EAC461CA227D7ABAD089FA0")) {
        processC59D80628EAC461CA227D7ABAD089FA0(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonBBF5C85870774F0C89D1DCF8F7767F76")) {
        processBBF5C85870774F0C89D1DCF8F7767F76(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6278DF8D5F1D4091967DDB1733EB7622")) {
        process6278DF8D5F1D4091967DDB1733EB7622(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton864EAE677EE747ABB219FC888F16B44E")) {
        process864EAE677EE747ABB219FC888F16B44E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton17A8F88150734A46AB11C3E5E3AEAC71")) {
        process17A8F88150734A46AB11C3E5E3AEAC71(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonAF99C0A0D75D490D80FEA24430E819FB")) {
        processAF99C0A0D75D490D80FEA24430E819FB(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton60B20166BD984E8EBCB9ABCA90329BCA")) {
        process60B20166BD984E8EBCB9ABCA90329BCA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonA3D36D357A9F48DDB7507FCADC8465F3")) {
        processA3D36D357A9F48DDB7507FCADC8465F3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton254354AEAC1645369FC71F81415993EB")) {
        process254354AEAC1645369FC71F81415993EB(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton75BDBA6366F349EB84D46C0443F8B398")) {
        process75BDBA6366F349EB84D46C0443F8B398(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6BCC36C351F24D5F8ED72999F1C28220")) {
        process6BCC36C351F24D5F8ED72999F1C28220(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF873EC6D50E44F878E9505AF20394AC0")) {
        processF873EC6D50E44F878E9505AF20394AC0(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonAEC4E66A00274AEBBC4F1E61717A7C5F")) {
        processAEC4E66A00274AEBBC4F1E61717A7C5F(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton00AB8AD197244C8EAA90B9D7A79ABCE4")) {
        process00AB8AD197244C8EAA90B9D7A79ABCE4(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton803D4F81300C464E96E2CB3F9854588B")) {
        process803D4F81300C464E96E2CB3F9854588B(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonC80B03ECDAE345F782E8A10493BCE2B8")) {
        processC80B03ECDAE345F782E8A10493BCE2B8(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton33FAB6B9C73240B6829D03908C6CA448")) {
        process33FAB6B9C73240B6829D03908C6CA448(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonAF774550BCA74626ACBC6A9021EB1F88")) {
        processAF774550BCA74626ACBC6A9021EB1F88(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonC14ACFDEF17E458E90AD6072C93D78D8")) {
        processC14ACFDEF17E458E90AD6072C93D78D8(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton48D797375D1D421BB9F146AF8546E879")) {
        process48D797375D1D421BB9F146AF8546E879(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton943C8F5BEAAE44298C2572C727CF5614")) {
        process943C8F5BEAAE44298C2572C727CF5614(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9C4187630C0A44B3829B2A9120B3EBC8")) {
        process9C4187630C0A44B3829B2A9120B3EBC8(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7901FF7DF9444013904A03D8F86E1B7E")) {
        process7901FF7DF9444013904A03D8F86E1B7E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB0DCB2771D744EAA8F75B2B6530CABF8")) {
        processB0DCB2771D744EAA8F75B2B6530CABF8(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB8E6E808CF5645669553E79F67936C5A")) {
        processB8E6E808CF5645669553E79F67936C5A(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonE0B23E3E8CEB4CD19E5EBC059E59ECBA")) {
        processE0B23E3E8CEB4CD19E5EBC059E59ECBA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton164D2FFC9D184D7DA75085943AB657A5")) {
        process164D2FFC9D184D7DA75085943AB657A5(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF3D2D70E07914B0A9D2023D95EE4F5EA")) {
        processF3D2D70E07914B0A9D2023D95EE4F5EA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD78F7B34CE624A778B8B064F96115122")) {
        processD78F7B34CE624A778B8B064F96115122(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0483599196D442B0B7C4032DF3CD1496")) {
        process0483599196D442B0B7C4032DF3CD1496(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0A94232190EE46A2B4D13CBF30C8F423")) {
        process0A94232190EE46A2B4D13CBF30C8F423(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5192F005F0524EE1A59AD3DCA8CDF4A3")) {
        process5192F005F0524EE1A59AD3DCA8CDF4A3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonE74903303FE742EA93A4FA456DB444EC")) {
        processE74903303FE742EA93A4FA456DB444EC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDBF26D81854746A19B1F2B1F0B4C0952")) {
        processDBF26D81854746A19B1F2B1F0B4C0952(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCBD470CCB8274C60AB970DD9A8B9C9AD")) {
        processCBD470CCB8274C60AB970DD9A8B9C9AD(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton1D22EE8C9F834A8E8051257DE39CBDB4")) {
        process1D22EE8C9F834A8E8051257DE39CBDB4(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF41B28D5D2294D9B930D6D2E0C38BAEF")) {
        processF41B28D5D2294D9B930D6D2E0C38BAEF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonE1781F4CF87B4E898740D640FC454507")) {
        processE1781F4CF87B4E898740D640FC454507(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonEF5BF59C53944CB6BBE5A6A4CACE7926")) {
        processEF5BF59C53944CB6BBE5A6A4CACE7926(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonE18FC7C24D2647CE8F8BF88690E3A659")) {
        processE18FC7C24D2647CE8F8BF88690E3A659(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonA37402A9673B4048A245E413D60263B9")) {
        processA37402A9673B4048A245E413D60263B9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDFC1286B6CF8466F9E57A349A6BD6CA7")) {
        processDFC1286B6CF8466F9E57A349A6BD6CA7(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonC2D00205D53E4D2290EB232FE78F3667")) {
        processC2D00205D53E4D2290EB232FE78F3667(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA")) {
        processB5C20B60DD3F4B4D93442FB7BE2DA6EA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB88EEB979B6E4F92BAE22165681CA4AA")) {
        processB88EEB979B6E4F92BAE22165681CA4AA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonBD3E529180454E6FAEC68F644CFF068A")) {
        processBD3E529180454E6FAEC68F644CFF068A(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton364900DC81134D3FBF819F85AFF5E7EA")) {
        process364900DC81134D3FBF819F85AFF5E7EA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9EB67D7B8AFA4BD9BBA09BDA63EAA271")) {
        process9EB67D7B8AFA4BD9BBA09BDA63EAA271(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton87FCB47E59564ED8AB7B2F927205A912")) {
        process87FCB47E59564ED8AB7B2F927205A912(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton77FC3840AB4A4814B8247BA69B484F87")) {
        process77FC3840AB4A4814B8247BA69B484F87(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD76FECE66C5748B1A30275734FFAFD5B")) {
        processD76FECE66C5748B1A30275734FFAFD5B(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5DBC17C8408D4F878C4BD37962A7F9F8")) {
        process5DBC17C8408D4F878C4BD37962A7F9F8(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton8079F08464854BBEB4199DA1C0D7545C")) {
        process8079F08464854BBEB4199DA1C0D7545C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton2F09CAACE6E14C8FA56CE0ED4C7582B4")) {
        process2F09CAACE6E14C8FA56CE0ED4C7582B4(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5523CFE2A7A149DF894C9CDD4A18DB88")) {
        process5523CFE2A7A149DF894C9CDD4A18DB88(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDF4E2B745B914942866105844E4ECFFC")) {
        processDF4E2B745B914942866105844E4ECFFC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFE7E37DEB4DF42F5853377E45E31A159")) {
        processFE7E37DEB4DF42F5853377E45E31A159(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton1715C3DFAAD94C1B8628D881A6EBBCFF")) {
        process1715C3DFAAD94C1B8628D881A6EBBCFF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6FBD65B0FDB74D1AB07F0EADF18D48AE")) {
        process6FBD65B0FDB74D1AB07F0EADF18D48AE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton590066A49B89482786E6183DC0E99FE3")) {
        process590066A49B89482786E6183DC0E99FE3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCE81B27EADC74667A59506719E70349A")) {
        processCE81B27EADC74667A59506719E70349A(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton135AFAA691B4481D85C9D913E4331101")) {
        process135AFAA691B4481D85C9D913E4331101(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3D6ECD5657D645F4B82ABD5CC2A09BF3")) {
        process3D6ECD5657D645F4B82ABD5CC2A09BF3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton66C88DC622C14C8EA9272AFE367A01E6")) {
        process66C88DC622C14C8EA9272AFE367A01E6(strProcessId, vars, request, response);

    } else pageErrorPopUp(response);
  }
  
  void printPageFrames(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("type", "ActionButtonJava_Responser.html");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }

  void printPageDefault(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefault").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
	  xmlDocument.setParameter("trlFormType", "PROCESS");
	  xmlDocument.setParameter("type", "ActionButtonJava_Responser.html");
	  xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }

    void printPageButton9DB4D30BFC5144B9B431CB49DDE9270D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9DB4D30BFC5144B9B431CB49DDE9270D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9DB4D30BFC5144B9B431CB49DDE9270D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9DB4D30BFC5144B9B431CB49DDE9270D");
        vars.removeMessage("9DB4D30BFC5144B9B431CB49DDE9270D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton7CB6B4D1ECCF4036B3F111D2CF11AADE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7CB6B4D1ECCF4036B3F111D2CF11AADE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7CB6B4D1ECCF4036B3F111D2CF11AADE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7CB6B4D1ECCF4036B3F111D2CF11AADE");
        vars.removeMessage("7CB6B4D1ECCF4036B3F111D2CF11AADE");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Warehouse_ID", Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    xmlDocument.setData("reportM_Warehouse_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton970EAD9B846648A7AB1F0CCA5058356C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 970EAD9B846648A7AB1F0CCA5058356C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton970EAD9B846648A7AB1F0CCA5058356C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("970EAD9B846648A7AB1F0CCA5058356C");
        vars.removeMessage("970EAD9B846648A7AB1F0CCA5058356C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Name", "");
    xmlDocument.setParameter("ImportAuditInfo", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton7EDBFEC35BDA4FF4AF05ED516CDAFB90(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7EDBFEC35BDA4FF4AF05ED516CDAFB90");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7EDBFEC35BDA4FF4AF05ED516CDAFB90", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7EDBFEC35BDA4FF4AF05ED516CDAFB90");
        vars.removeMessage("7EDBFEC35BDA4FF4AF05ED516CDAFB90");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonABDFC8131D964936AD2EF7E0CED97FD9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process ABDFC8131D964936AD2EF7E0CED97FD9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonABDFC8131D964936AD2EF7E0CED97FD9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("ABDFC8131D964936AD2EF7E0CED97FD9");
        vars.removeMessage("ABDFC8131D964936AD2EF7E0CED97FD9");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton3C386BC12832466790E50F2F8C5EBD85(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3C386BC12832466790E50F2F8C5EBD85");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3C386BC12832466790E50F2F8C5EBD85", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("3C386BC12832466790E50F2F8C5EBD85");
        vars.removeMessage("3C386BC12832466790E50F2F8C5EBD85");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonEFDBF909811544DAAE4E876AA781E5DC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EFDBF909811544DAAE4E876AA781E5DC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonEFDBF909811544DAAE4E876AA781E5DC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("EFDBF909811544DAAE4E876AA781E5DC");
        vars.removeMessage("EFDBF909811544DAAE4E876AA781E5DC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton107(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 107");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton107", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("107");
        vars.removeMessage("107");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCD7283DF804B449C97DA09446669EEEF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CD7283DF804B449C97DA09446669EEEF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCD7283DF804B449C97DA09446669EEEF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CD7283DF804B449C97DA09446669EEEF");
        vars.removeMessage("CD7283DF804B449C97DA09446669EEEF");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton85601427EAEE401FA0250FF0A6DD62EF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 85601427EAEE401FA0250FF0A6DD62EF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton85601427EAEE401FA0250FF0A6DD62EF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("85601427EAEE401FA0250FF0A6DD62EF");
        vars.removeMessage("85601427EAEE401FA0250FF0A6DD62EF");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonA3FE1F9892394386A49FB707AA50A0FA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A3FE1F9892394386A49FB707AA50A0FA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonA3FE1F9892394386A49FB707AA50A0FA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("A3FE1F9892394386A49FB707AA50A0FA");
        vars.removeMessage("A3FE1F9892394386A49FB707AA50A0FA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("RecalculatePrices", "Y");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton136(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 136");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton136", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("136");
        vars.removeMessage("136");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFB740AB61B0E42B198D2C88D3A0D0CE6(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FB740AB61B0E42B198D2C88D3A0D0CE6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFB740AB61B0E42B198D2C88D3A0D0CE6", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FB740AB61B0E42B198D2C88D3A0D0CE6");
        vars.removeMessage("FB740AB61B0E42B198D2C88D3A0D0CE6");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("DueDate", Utility.getContext(this, vars, "Duedate", ""));
    xmlDocument.setParameter("DueDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("FIN_Payment_Priority_ID", Utility.getContext(this, vars, "FIN_Payment_Priority_ID", ""));
    comboTableData = new ComboTableData(vars, this, "19", "FIN_Payment_Priority_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "FIN_Payment_Priority_ID", ""));
    xmlDocument.setData("reportFIN_Payment_Priority_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton58591E3E0F7648E4A09058E037CE49FC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 58591E3E0F7648E4A09058E037CE49FC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton58591E3E0F7648E4A09058E037CE49FC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("58591E3E0F7648E4A09058E037CE49FC");
        vars.removeMessage("58591E3E0F7648E4A09058E037CE49FC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    xmlDocument.setParameter("M_Product_IDR", "");
    xmlDocument.setParameter("M_CH_Value_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_CH_Value_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_CH_Value_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton64B3FF29AC174F4B94538BD0A3CE1CD3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 64B3FF29AC174F4B94538BD0A3CE1CD3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton64B3FF29AC174F4B94538BD0A3CE1CD3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("64B3FF29AC174F4B94538BD0A3CE1CD3");
        vars.removeMessage("64B3FF29AC174F4B94538BD0A3CE1CD3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton23D1B163EC0B41F790CE39BF01DA320E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 23D1B163EC0B41F790CE39BF01DA320E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton23D1B163EC0B41F790CE39BF01DA320E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("23D1B163EC0B41F790CE39BF01DA320E");
        vars.removeMessage("23D1B163EC0B41F790CE39BF01DA320E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    xmlDocument.setParameter("M_AttributeSetInstance_ID", "");
    xmlDocument.setParameter("M_AttributeSetInstance_IDR", "");
    xmlDocument.setParameter("Returned", "");
    xmlDocument.setParameter("PriceStd", "");
    xmlDocument.setParameter("C_Tax_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Tax_ID", "", "299FA667CF374AC5ACC74739C3251134", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Tax_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Return_Reason_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Return_Reason_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Return_Reason_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton9EB2228A60684C0DBEC12D5CD8D85218(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9EB2228A60684C0DBEC12D5CD8D85218");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9EB2228A60684C0DBEC12D5CD8D85218", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9EB2228A60684C0DBEC12D5CD8D85218");
        vars.removeMessage("9EB2228A60684C0DBEC12D5CD8D85218");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD85D5B5E368A49B1A6293BA4AE15F0F9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D85D5B5E368A49B1A6293BA4AE15F0F9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD85D5B5E368A49B1A6293BA4AE15F0F9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D85D5B5E368A49B1A6293BA4AE15F0F9");
        vars.removeMessage("D85D5B5E368A49B1A6293BA4AE15F0F9");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Ad_Client_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportAd_Client_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("ExportAuditInfo", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF80808133362F6A013336781FCE0066(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF80808133362F6A013336781FCE0066");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF80808133362F6A013336781FCE0066", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF80808133362F6A013336781FCE0066");
        vars.removeMessage("FF80808133362F6A013336781FCE0066");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF8081813219E68E013219ECFE930004(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF8081813219E68E013219ECFE930004");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF8081813219E68E013219ECFE930004", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF8081813219E68E013219ECFE930004");
        vars.removeMessage("FF8081813219E68E013219ECFE930004");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Value", ActionButtonSQLDefaultData.selectActPFF8081813219E68E013219ECFE930004_Value(this, Utility.getContext(this, vars, "MA_SEQUENCEPRODUCT_ID", "")));
    xmlDocument.setParameter("Name", ActionButtonSQLDefaultData.selectActPFF8081813219E68E013219ECFE930004_Name(this, Utility.getContext(this, vars, "MA_SEQUENCEPRODUCT_ID", "")));
    xmlDocument.setParameter("M_Product_Category_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_Product_Category_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Product_Category_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Productiontype", "+");
    comboTableData = new ComboTableData(vars, this, "17", "Productiontype", "800034", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "+");
    xmlDocument.setData("reportProductiontype", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Qty", "0");
    xmlDocument.setParameter("Copyattribute", "Y");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF808181324D007801324D2AE1130066(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF808181324D007801324D2AE1130066");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF808181324D007801324D2AE1130066", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF808181324D007801324D2AE1130066");
        vars.removeMessage("FF808181324D007801324D2AE1130066");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Date", "");
    xmlDocument.setParameter("Date_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("Starttime", "");
    xmlDocument.setParameter("Endtime", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF808181326CD80501326CE906D70042(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF808181326CD80501326CE906D70042");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF808181326CD80501326CE906D70042", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF808181326CD80501326CE906D70042");
        vars.removeMessage("FF808181326CD80501326CE906D70042");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF80818132A4F6AD0132A573DD7A0021(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF80818132A4F6AD0132A573DD7A0021");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF80818132A4F6AD0132A573DD7A0021", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF80818132A4F6AD0132A573DD7A0021");
        vars.removeMessage("FF80818132A4F6AD0132A573DD7A0021");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton2DDE7D3618034C38A4462B7F3456C28D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 2DDE7D3618034C38A4462B7F3456C28D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton2DDE7D3618034C38A4462B7F3456C28D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("2DDE7D3618034C38A4462B7F3456C28D");
        vars.removeMessage("2DDE7D3618034C38A4462B7F3456C28D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6BF16EFC772843AC9A17552AE0B26AB7(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6BF16EFC772843AC9A17552AE0B26AB7");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6BF16EFC772843AC9A17552AE0B26AB7", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6BF16EFC772843AC9A17552AE0B26AB7");
        vars.removeMessage("6BF16EFC772843AC9A17552AE0B26AB7");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "Process_Reconciliation", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "Process_Reconciliation", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0BDC2164ED3E48539FCEF4D306F29EFD(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0BDC2164ED3E48539FCEF4D306F29EFD");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0BDC2164ED3E48539FCEF4D306F29EFD", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0BDC2164ED3E48539FCEF4D306F29EFD");
        vars.removeMessage("0BDC2164ED3E48539FCEF4D306F29EFD");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "");
    comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton5BE14AA10165490A9ADEFB7532F7FA94(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5BE14AA10165490A9ADEFB7532F7FA94");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5BE14AA10165490A9ADEFB7532F7FA94", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("5BE14AA10165490A9ADEFB7532F7FA94");
        vars.removeMessage("5BE14AA10165490A9ADEFB7532F7FA94");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton58A9261BACEF45DDA526F29D8557272D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 58A9261BACEF45DDA526F29D8557272D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton58A9261BACEF45DDA526F29D8557272D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("58A9261BACEF45DDA526F29D8557272D");
        vars.removeMessage("58A9261BACEF45DDA526F29D8557272D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton15C8708DFC464C2D91286E59624FDD18(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 15C8708DFC464C2D91286E59624FDD18");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton15C8708DFC464C2D91286E59624FDD18", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("15C8708DFC464C2D91286E59624FDD18");
        vars.removeMessage("15C8708DFC464C2D91286E59624FDD18");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("C_GLItem_ID", ActionButtonSQLDefaultData.selectActP15C8708DFC464C2D91286E59624FDD18_C_GLItem_ID(this, Utility.getContext(this, vars, "C_GLItem_ID", "")));
    xmlDocument.setParameter("M_Product_ID", Utility.getContext(this, vars, "M_Product_ID", ""));
    xmlDocument.setParameter("C_BPartner_ID", Utility.getContext(this, vars, "C_Bpartner_ID", ""));
    xmlDocument.setParameter("C_Project_ID", Utility.getContext(this, vars, "C_Project_ID", ""));
    xmlDocument.setParameter("C_Campaign_ID", Utility.getContext(this, vars, "C_Campaign_ID", ""));
    xmlDocument.setParameter("C_Activity_ID", Utility.getContext(this, vars, "C_Activity_ID", ""));
    xmlDocument.setParameter("C_SalesRegion_ID", Utility.getContext(this, vars, "C_Salesregion_ID", ""));
    xmlDocument.setParameter("C_Costcenter_ID", Utility.getContext(this, vars, "C_Costcenter_ID", ""));
    xmlDocument.setParameter("User1_ID", Utility.getContext(this, vars, "User1_ID", ""));
    xmlDocument.setParameter("User2_ID", Utility.getContext(this, vars, "User2_ID", ""));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton017312F51139438A9665775E3B5392A1(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 017312F51139438A9665775E3B5392A1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton017312F51139438A9665775E3B5392A1", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("017312F51139438A9665775E3B5392A1");
        vars.removeMessage("017312F51139438A9665775E3B5392A1");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "");
    comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6255BE488882480599C81284B70CD9B3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6255BE488882480599C81284B70CD9B3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6255BE488882480599C81284B70CD9B3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6255BE488882480599C81284B70CD9B3");
        vars.removeMessage("6255BE488882480599C81284B70CD9B3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "EM_APRM_Process_Payment", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "36972531DA994BB38ECB91993058282F", "575E470ABADB4C278132C957A78C47E3", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "EM_APRM_Process_Payment", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF68F2890E96D4D85A1DEF0274D105BCE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F68F2890E96D4D85A1DEF0274D105BCE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF68F2890E96D4D85A1DEF0274D105BCE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F68F2890E96D4D85A1DEF0274D105BCE");
        vars.removeMessage("F68F2890E96D4D85A1DEF0274D105BCE");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "");
    comboTableData = new ComboTableData(vars, this, "17", "action", "F671DDEA466D41A996F605590CB545BC", "FAE0D7C8A9D84FAFAE3C10CD5DCE6E30", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton29D17F515727436DBCE32BC6CA28382B(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 29D17F515727436DBCE32BC6CA28382B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton29D17F515727436DBCE32BC6CA28382B", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("29D17F515727436DBCE32BC6CA28382B");
        vars.removeMessage("29D17F515727436DBCE32BC6CA28382B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "RV");
    comboTableData = new ComboTableData(vars, this, "17", "action", "66F2DCC800A34F94923444C29478E70A", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "RV");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("paymentDate", "");
    xmlDocument.setParameter("paymentDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonDE1B382FDD2540199D223586F6E216D0(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DE1B382FDD2540199D223586F6E216D0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDE1B382FDD2540199D223586F6E216D0", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("DE1B382FDD2540199D223586F6E216D0");
        vars.removeMessage("DE1B382FDD2540199D223586F6E216D0");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD16966FBF9604A3D91A50DC83C6EA8E3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D16966FBF9604A3D91A50DC83C6EA8E3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD16966FBF9604A3D91A50DC83C6EA8E3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D16966FBF9604A3D91A50DC83C6EA8E3");
        vars.removeMessage("D16966FBF9604A3D91A50DC83C6EA8E3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF8080812E2F8EAE012E2F94CF470014(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF8080812E2F8EAE012E2F94CF470014");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF8080812E2F8EAE012E2F94CF470014", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF8080812E2F8EAE012E2F94CF470014");
        vars.removeMessage("FF8080812E2F8EAE012E2F94CF470014");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "Process_Reconciliation", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "Process_Reconciliation", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF8080812F348A97012F349DC24F0007(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF8080812F348A97012F349DC24F0007");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF8080812F348A97012F349DC24F0007", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF8080812F348A97012F349DC24F0007");
        vars.removeMessage("FF8080812F348A97012F349DC24F0007");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton66912CD2D96B494FA23F4AF2B7F795BA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 66912CD2D96B494FA23F4AF2B7F795BA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton66912CD2D96B494FA23F4AF2B7F795BA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("66912CD2D96B494FA23F4AF2B7F795BA");
        vars.removeMessage("66912CD2D96B494FA23F4AF2B7F795BA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonBED3CF78244147038E632AC2700C4F22(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BED3CF78244147038E632AC2700C4F22");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonBED3CF78244147038E632AC2700C4F22", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("BED3CF78244147038E632AC2700C4F22");
        vars.removeMessage("BED3CF78244147038E632AC2700C4F22");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Documentno", "");
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton4380C4EBA98A4E7EB784ABC1360FE8EA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4380C4EBA98A4E7EB784ABC1360FE8EA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton4380C4EBA98A4E7EB784ABC1360FE8EA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("4380C4EBA98A4E7EB784ABC1360FE8EA");
        vars.removeMessage("4380C4EBA98A4E7EB784ABC1360FE8EA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_YEAR_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "185F8664184A47B0BDC46266BA399B11", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_YEAR_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton8388633AADD04FC487A0AEA775448333(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8388633AADD04FC487A0AEA775448333");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton8388633AADD04FC487A0AEA775448333", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("8388633AADD04FC487A0AEA775448333");
        vars.removeMessage("8388633AADD04FC487A0AEA775448333");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD10230FC59154A12ABC9FA6B4A9E4080(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D10230FC59154A12ABC9FA6B4A9E4080");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD10230FC59154A12ABC9FA6B4A9E4080", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D10230FC59154A12ABC9FA6B4A9E4080");
        vars.removeMessage("D10230FC59154A12ABC9FA6B4A9E4080");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Period_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "A22A0AE42F70499EB8ECEA83A25E6131", "F82DA8938E894B67812FCF23D82CA50D", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Period_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton9E930637C9B44A73B0227D49AA30DD12(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9E930637C9B44A73B0227D49AA30DD12");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9E930637C9B44A73B0227D49AA30DD12", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9E930637C9B44A73B0227D49AA30DD12");
        vars.removeMessage("9E930637C9B44A73B0227D49AA30DD12");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("ad_org_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportad_org_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("c_city_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_city_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_city_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("c_period_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "c_period_id", "A22A0AE42F70499EB8ECEA83A25E6131", "F82DA8938E894B67812FCF23D82CA50D", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_period_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton71146C7A96774E58A772B98A8B1C6953(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 71146C7A96774E58A772B98A8B1C6953");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton71146C7A96774E58A772B98A8B1C6953", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("71146C7A96774E58A772B98A8B1C6953");
        vars.removeMessage("71146C7A96774E58A772B98A8B1C6953");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCD35DC8F54624AC0948C891C7F7E70A1(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CD35DC8F54624AC0948C891C7F7E70A1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCD35DC8F54624AC0948C891C7F7E70A1", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CD35DC8F54624AC0948C891C7F7E70A1");
        vars.removeMessage("CD35DC8F54624AC0948C891C7F7E70A1");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton3B45D448EACA44FF9BD084C302459014(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3B45D448EACA44FF9BD084C302459014");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3B45D448EACA44FF9BD084C302459014", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("3B45D448EACA44FF9BD084C302459014");
        vars.removeMessage("3B45D448EACA44FF9BD084C302459014");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("c_year_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_year_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_year_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Ssfi_Banktransfer_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "Ssfi_Banktransfer_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportSsfi_Banktransfer_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sspr_category_acct_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("c_Costcenter_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_Costcenter_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_Costcenter_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton3FAE7B1AB61F4E61B67481247AE8215F(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3FAE7B1AB61F4E61B67481247AE8215F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3FAE7B1AB61F4E61B67481247AE8215F", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("3FAE7B1AB61F4E61B67481247AE8215F");
        vars.removeMessage("3FAE7B1AB61F4E61B67481247AE8215F");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0AF06FA75CC348D98ECBD5FFFEF79330(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0AF06FA75CC348D98ECBD5FFFEF79330");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0AF06FA75CC348D98ECBD5FFFEF79330", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0AF06FA75CC348D98ECBD5FFFEF79330");
        vars.removeMessage("0AF06FA75CC348D98ECBD5FFFEF79330");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Year_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Year_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Year_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton4FB68828FA684DAAA1478926ED32B84C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4FB68828FA684DAAA1478926ED32B84C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton4FB68828FA684DAAA1478926ED32B84C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("4FB68828FA684DAAA1478926ED32B84C");
        vars.removeMessage("4FB68828FA684DAAA1478926ED32B84C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sspr_category_acct_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("c_Costcenter_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_Costcenter_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_Costcenter_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton21C4B0035C5645109223814F0DD91AB5(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 21C4B0035C5645109223814F0DD91AB5");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton21C4B0035C5645109223814F0DD91AB5", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("21C4B0035C5645109223814F0DD91AB5");
        vars.removeMessage("21C4B0035C5645109223814F0DD91AB5");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0D9C391058AC4367BCC71DA7D39DE4C3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0D9C391058AC4367BCC71DA7D39DE4C3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0D9C391058AC4367BCC71DA7D39DE4C3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0D9C391058AC4367BCC71DA7D39DE4C3");
        vars.removeMessage("0D9C391058AC4367BCC71DA7D39DE4C3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("c_year_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_year_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_year_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton418D9416C62B4087BE59A1B358910954(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 418D9416C62B4087BE59A1B358910954");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton418D9416C62B4087BE59A1B358910954", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("418D9416C62B4087BE59A1B358910954");
        vars.removeMessage("418D9416C62B4087BE59A1B358910954");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("sspr_category_acct_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sendno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton837888BA221D47E6915FDE6DD361C1D9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 837888BA221D47E6915FDE6DD361C1D9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton837888BA221D47E6915FDE6DD361C1D9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("837888BA221D47E6915FDE6DD361C1D9");
        vars.removeMessage("837888BA221D47E6915FDE6DD361C1D9");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton72380902AAEC47B4A493717B4D504E9E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 72380902AAEC47B4A493717B4D504E9E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton72380902AAEC47B4A493717B4D504E9E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("72380902AAEC47B4A493717B4D504E9E");
        vars.removeMessage("72380902AAEC47B4A493717B4D504E9E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton7CC8083871A2456BAC7B948F3510BC3C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7CC8083871A2456BAC7B948F3510BC3C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7CC8083871A2456BAC7B948F3510BC3C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7CC8083871A2456BAC7B948F3510BC3C");
        vars.removeMessage("7CC8083871A2456BAC7B948F3510BC3C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton39774700D5B041BEB5DCC4CFF9E16CBE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 39774700D5B041BEB5DCC4CFF9E16CBE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton39774700D5B041BEB5DCC4CFF9E16CBE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("39774700D5B041BEB5DCC4CFF9E16CBE");
        vars.removeMessage("39774700D5B041BEB5DCC4CFF9E16CBE");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Documentno", "");
    xmlDocument.setParameter("Ssfi_Banktransfer_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "Ssfi_Banktransfer_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportSsfi_Banktransfer_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sspr_category_acct_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("c_Costcenter_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_Costcenter_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_Costcenter_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton437B1EE180984960A698FB8154DE5D35(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 437B1EE180984960A698FB8154DE5D35");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton437B1EE180984960A698FB8154DE5D35", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("437B1EE180984960A698FB8154DE5D35");
        vars.removeMessage("437B1EE180984960A698FB8154DE5D35");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_YEAR_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "AB8C3318A0034E4CBA38D0820F37BF65", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_YEAR_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputtype", "");
    comboTableData = new ComboTableData(vars, this, "17", "outputtype", "53913B77F5684D31AE4C69CE5E8B3FDC", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportoutputtype", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonDD60049F200E490BA823A5B3532F57B4(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DD60049F200E490BA823A5B3532F57B4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDD60049F200E490BA823A5B3532F57B4", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("DD60049F200E490BA823A5B3532F57B4");
        vars.removeMessage("DD60049F200E490BA823A5B3532F57B4");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("c_doctype_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_doctype_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_doctype_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("datefrom", "");
    xmlDocument.setParameter("datefrom_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateto", "");
    xmlDocument.setParameter("dateto_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("FIN_Financial_Account_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "FIN_Financial_Account_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportFIN_Financial_Account_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sendno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton05E6E7C50BE3447392C9BC02EB86500D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 05E6E7C50BE3447392C9BC02EB86500D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton05E6E7C50BE3447392C9BC02EB86500D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("05E6E7C50BE3447392C9BC02EB86500D");
        vars.removeMessage("05E6E7C50BE3447392C9BC02EB86500D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton98EC8B6FBAC145CA926C4740A2C2B6FF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 98EC8B6FBAC145CA926C4740A2C2B6FF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton98EC8B6FBAC145CA926C4740A2C2B6FF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("98EC8B6FBAC145CA926C4740A2C2B6FF");
        vars.removeMessage("98EC8B6FBAC145CA926C4740A2C2B6FF");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("sspr_category_acct_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sendno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton9337D1CEEC0647B888EC257259F025B2(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9337D1CEEC0647B888EC257259F025B2");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9337D1CEEC0647B888EC257259F025B2", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9337D1CEEC0647B888EC257259F025B2");
        vars.removeMessage("9337D1CEEC0647B888EC257259F025B2");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("AD_ORG_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportAD_ORG_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Ats_Type", "");
    comboTableData = new ComboTableData(vars, this, "17", "Ats_Type", "053A5CA7D0074EE88F8EAA1BD65FB76E", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportAts_Type", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Semester", "");
    comboTableData = new ComboTableData(vars, this, "17", "Semester", "E604985995FA4165A296AD98DC495CBD", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportSemester", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_YEAR_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "36A5245EC9594447BAB449E060F4018E", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_YEAR_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Period_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "0B30149ACA2043C3A6642049C22A262A", "88661FA3F6F4410BAF6A85FB0F1B516B", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Period_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD93CCE4D4D954542BD7AA2F107404BAD(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D93CCE4D4D954542BD7AA2F107404BAD");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD93CCE4D4D954542BD7AA2F107404BAD", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D93CCE4D4D954542BD7AA2F107404BAD");
        vars.removeMessage("D93CCE4D4D954542BD7AA2F107404BAD");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("c_year_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "c_year_id", "DA52367C92304C72809B5302A830BADC", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_year_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD4F242B223A947238DEC0C1727C29D7B(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D4F242B223A947238DEC0C1727C29D7B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD4F242B223A947238DEC0C1727C29D7B", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D4F242B223A947238DEC0C1727C29D7B");
        vars.removeMessage("D4F242B223A947238DEC0C1727C29D7B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "8BB4CFC1699840B5B77310E836B29370", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton177A8D600E334A188E193EC8C647AED0(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 177A8D600E334A188E193EC8C647AED0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton177A8D600E334A188E193EC8C647AED0", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("177A8D600E334A188E193EC8C647AED0");
        vars.removeMessage("177A8D600E334A188E193EC8C647AED0");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6F5F5FCC3C124629A02179A1D55DB636(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6F5F5FCC3C124629A02179A1D55DB636");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6F5F5FCC3C124629A02179A1D55DB636", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6F5F5FCC3C124629A02179A1D55DB636");
        vars.removeMessage("6F5F5FCC3C124629A02179A1D55DB636");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton3A53E5B4438A432EA7F48FD4A4FB9992(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3A53E5B4438A432EA7F48FD4A4FB9992");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3A53E5B4438A432EA7F48FD4A4FB9992", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("3A53E5B4438A432EA7F48FD4A4FB9992");
        vars.removeMessage("3A53E5B4438A432EA7F48FD4A4FB9992");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonED5960492A2C41929D59442D2C38F174(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process ED5960492A2C41929D59442D2C38F174");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonED5960492A2C41929D59442D2C38F174", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("ED5960492A2C41929D59442D2C38F174");
        vars.removeMessage("ED5960492A2C41929D59442D2C38F174");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton8483E826BD4A4F4FABE988B7EE7193EC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8483E826BD4A4F4FABE988B7EE7193EC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton8483E826BD4A4F4FABE988B7EE7193EC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("8483E826BD4A4F4FABE988B7EE7193EC");
        vars.removeMessage("8483E826BD4A4F4FABE988B7EE7193EC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF57CB7A61C8F47E3AE2F19B740C2B72C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F57CB7A61C8F47E3AE2F19B740C2B72C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF57CB7A61C8F47E3AE2F19B740C2B72C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F57CB7A61C8F47E3AE2F19B740C2B72C");
        vars.removeMessage("F57CB7A61C8F47E3AE2F19B740C2B72C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "02E7D57030AE46BDA146F56852513605", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton36F2D08523FE4E4C9A8B8000CDEF2A39(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 36F2D08523FE4E4C9A8B8000CDEF2A39");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton36F2D08523FE4E4C9A8B8000CDEF2A39", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("36F2D08523FE4E4C9A8B8000CDEF2A39");
        vars.removeMessage("36F2D08523FE4E4C9A8B8000CDEF2A39");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton50A6708720CB4B7D9A62222AAFF04579(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 50A6708720CB4B7D9A62222AAFF04579");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton50A6708720CB4B7D9A62222AAFF04579", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("50A6708720CB4B7D9A62222AAFF04579");
        vars.removeMessage("50A6708720CB4B7D9A62222AAFF04579");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("fecha", "");
    xmlDocument.setParameter("fecha_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF5B1A584BF824E3FAC430E032F020F4E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F5B1A584BF824E3FAC430E032F020F4E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF5B1A584BF824E3FAC430E032F020F4E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F5B1A584BF824E3FAC430E032F020F4E");
        vars.removeMessage("F5B1A584BF824E3FAC430E032F020F4E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton364164C3FDC54156936DD179969F46B6(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 364164C3FDC54156936DD179969F46B6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton364164C3FDC54156936DD179969F46B6", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("364164C3FDC54156936DD179969F46B6");
        vars.removeMessage("364164C3FDC54156936DD179969F46B6");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton1BBCF97310864568BE34873F36850CC9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1BBCF97310864568BE34873F36850CC9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton1BBCF97310864568BE34873F36850CC9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("1BBCF97310864568BE34873F36850CC9");
        vars.removeMessage("1BBCF97310864568BE34873F36850CC9");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCF5B8CCBDB3B46978A3A202D742E323D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CF5B8CCBDB3B46978A3A202D742E323D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCF5B8CCBDB3B46978A3A202D742E323D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CF5B8CCBDB3B46978A3A202D742E323D");
        vars.removeMessage("CF5B8CCBDB3B46978A3A202D742E323D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton93A46131F08141FA81C13B9D82A1F80C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 93A46131F08141FA81C13B9D82A1F80C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton93A46131F08141FA81C13B9D82A1F80C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("93A46131F08141FA81C13B9D82A1F80C");
        vars.removeMessage("93A46131F08141FA81C13B9D82A1F80C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("DocumentNo", "");
    xmlDocument.setParameter("Typeofincome", "");
    comboTableData = new ComboTableData(vars, this, "17", "Typeofincome", "85DB1E4AE10940FB825CA20F93C0BF06", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportTypeofincome", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton5CF52155581B47CAAF5601D5C5DA93B3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5CF52155581B47CAAF5601D5C5DA93B3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5CF52155581B47CAAF5601D5C5DA93B3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("5CF52155581B47CAAF5601D5C5DA93B3");
        vars.removeMessage("5CF52155581B47CAAF5601D5C5DA93B3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sspr_category_acct_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton00052E7428F8477CAACCE14830F8F43E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 00052E7428F8477CAACCE14830F8F43E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton00052E7428F8477CAACCE14830F8F43E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("00052E7428F8477CAACCE14830F8F43E");
        vars.removeMessage("00052E7428F8477CAACCE14830F8F43E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton01DA33DE7D4B443A8CBF5867B6B1C6C6(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 01DA33DE7D4B443A8CBF5867B6B1C6C6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton01DA33DE7D4B443A8CBF5867B6B1C6C6", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("01DA33DE7D4B443A8CBF5867B6B1C6C6");
        vars.removeMessage("01DA33DE7D4B443A8CBF5867B6B1C6C6");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD244C9919E6747AD9DF9B43D1E1C6233(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D244C9919E6747AD9DF9B43D1E1C6233");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD244C9919E6747AD9DF9B43D1E1C6233", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D244C9919E6747AD9DF9B43D1E1C6233");
        vars.removeMessage("D244C9919E6747AD9DF9B43D1E1C6233");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0C26D138283A4702AE8657D0B2755511(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0C26D138283A4702AE8657D0B2755511");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0C26D138283A4702AE8657D0B2755511", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0C26D138283A4702AE8657D0B2755511");
        vars.removeMessage("0C26D138283A4702AE8657D0B2755511");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton1B5C7B74144344F7BF8154C73891E1F7(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1B5C7B74144344F7BF8154C73891E1F7");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton1B5C7B74144344F7BF8154C73891E1F7", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("1B5C7B74144344F7BF8154C73891E1F7");
        vars.removeMessage("1B5C7B74144344F7BF8154C73891E1F7");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton29604C7EF05B44C0AA36ACF4CF48528A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 29604C7EF05B44C0AA36ACF4CF48528A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton29604C7EF05B44C0AA36ACF4CF48528A", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("29604C7EF05B44C0AA36ACF4CF48528A");
        vars.removeMessage("29604C7EF05B44C0AA36ACF4CF48528A");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonC59D80628EAC461CA227D7ABAD089FA0(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C59D80628EAC461CA227D7ABAD089FA0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonC59D80628EAC461CA227D7ABAD089FA0", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("C59D80628EAC461CA227D7ABAD089FA0");
        vars.removeMessage("C59D80628EAC461CA227D7ABAD089FA0");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Offer_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_Offer_ID", "", "B10AF6107A3F4D4EA5F07483AC1A37C2", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Offer_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Qty", "1");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonBBF5C85870774F0C89D1DCF8F7767F76(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BBF5C85870774F0C89D1DCF8F7767F76");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonBBF5C85870774F0C89D1DCF8F7767F76", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("BBF5C85870774F0C89D1DCF8F7767F76");
        vars.removeMessage("BBF5C85870774F0C89D1DCF8F7767F76");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6278DF8D5F1D4091967DDB1733EB7622(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6278DF8D5F1D4091967DDB1733EB7622");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6278DF8D5F1D4091967DDB1733EB7622", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6278DF8D5F1D4091967DDB1733EB7622");
        vars.removeMessage("6278DF8D5F1D4091967DDB1733EB7622");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Obretco_Productlist_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "Obretco_Productlist_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportObretco_Productlist_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("generateAllImages", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton864EAE677EE747ABB219FC888F16B44E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 864EAE677EE747ABB219FC888F16B44E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton864EAE677EE747ABB219FC888F16B44E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("864EAE677EE747ABB219FC888F16B44E");
        vars.removeMessage("864EAE677EE747ABB219FC888F16B44E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton17A8F88150734A46AB11C3E5E3AEAC71(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 17A8F88150734A46AB11C3E5E3AEAC71");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton17A8F88150734A46AB11C3E5E3AEAC71", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("17A8F88150734A46AB11C3E5E3AEAC71");
        vars.removeMessage("17A8F88150734A46AB11C3E5E3AEAC71");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonAF99C0A0D75D490D80FEA24430E819FB(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AF99C0A0D75D490D80FEA24430E819FB");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonAF99C0A0D75D490D80FEA24430E819FB", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("AF99C0A0D75D490D80FEA24430E819FB");
        vars.removeMessage("AF99C0A0D75D490D80FEA24430E819FB");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton60B20166BD984E8EBCB9ABCA90329BCA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 60B20166BD984E8EBCB9ABCA90329BCA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton60B20166BD984E8EBCB9ABCA90329BCA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("60B20166BD984E8EBCB9ABCA90329BCA");
        vars.removeMessage("60B20166BD984E8EBCB9ABCA90329BCA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("ChangeDate", "");
    xmlDocument.setParameter("ChangeDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("StartDate", "");
    xmlDocument.setParameter("StartDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("NewAssetValue", "");
    xmlDocument.setParameter("UsefulLife", "");
    xmlDocument.setParameter("Description", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonA3D36D357A9F48DDB7507FCADC8465F3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A3D36D357A9F48DDB7507FCADC8465F3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonA3D36D357A9F48DDB7507FCADC8465F3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("A3D36D357A9F48DDB7507FCADC8465F3");
        vars.removeMessage("A3D36D357A9F48DDB7507FCADC8465F3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton254354AEAC1645369FC71F81415993EB(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 254354AEAC1645369FC71F81415993EB");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton254354AEAC1645369FC71F81415993EB", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("254354AEAC1645369FC71F81415993EB");
        vars.removeMessage("254354AEAC1645369FC71F81415993EB");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton75BDBA6366F349EB84D46C0443F8B398(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 75BDBA6366F349EB84D46C0443F8B398");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton75BDBA6366F349EB84D46C0443F8B398", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("75BDBA6366F349EB84D46C0443F8B398");
        vars.removeMessage("75BDBA6366F349EB84D46C0443F8B398");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6BCC36C351F24D5F8ED72999F1C28220(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6BCC36C351F24D5F8ED72999F1C28220");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6BCC36C351F24D5F8ED72999F1C28220", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6BCC36C351F24D5F8ED72999F1C28220");
        vars.removeMessage("6BCC36C351F24D5F8ED72999F1C28220");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF873EC6D50E44F878E9505AF20394AC0(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F873EC6D50E44F878E9505AF20394AC0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF873EC6D50E44F878E9505AF20394AC0", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F873EC6D50E44F878E9505AF20394AC0");
        vars.removeMessage("F873EC6D50E44F878E9505AF20394AC0");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonAEC4E66A00274AEBBC4F1E61717A7C5F(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AEC4E66A00274AEBBC4F1E61717A7C5F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonAEC4E66A00274AEBBC4F1E61717A7C5F", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("AEC4E66A00274AEBBC4F1E61717A7C5F");
        vars.removeMessage("AEC4E66A00274AEBBC4F1E61717A7C5F");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("DATE_FROM", "");
    xmlDocument.setParameter("DATE_FROM_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("DATE_TO", "");
    xmlDocument.setParameter("DATE_TO_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton00AB8AD197244C8EAA90B9D7A79ABCE4(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 00AB8AD197244C8EAA90B9D7A79ABCE4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton00AB8AD197244C8EAA90B9D7A79ABCE4", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("00AB8AD197244C8EAA90B9D7A79ABCE4");
        vars.removeMessage("00AB8AD197244C8EAA90B9D7A79ABCE4");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton803D4F81300C464E96E2CB3F9854588B(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 803D4F81300C464E96E2CB3F9854588B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton803D4F81300C464E96E2CB3F9854588B", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("803D4F81300C464E96E2CB3F9854588B");
        vars.removeMessage("803D4F81300C464E96E2CB3F9854588B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Date", "");
    xmlDocument.setParameter("Date_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("Starttime", "");
    xmlDocument.setParameter("Endtime", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonC80B03ECDAE345F782E8A10493BCE2B8(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C80B03ECDAE345F782E8A10493BCE2B8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonC80B03ECDAE345F782E8A10493BCE2B8", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("C80B03ECDAE345F782E8A10493BCE2B8");
        vars.removeMessage("C80B03ECDAE345F782E8A10493BCE2B8");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton33FAB6B9C73240B6829D03908C6CA448(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 33FAB6B9C73240B6829D03908C6CA448");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton33FAB6B9C73240B6829D03908C6CA448", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("33FAB6B9C73240B6829D03908C6CA448");
        vars.removeMessage("33FAB6B9C73240B6829D03908C6CA448");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonAF774550BCA74626ACBC6A9021EB1F88(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AF774550BCA74626ACBC6A9021EB1F88");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonAF774550BCA74626ACBC6A9021EB1F88", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("AF774550BCA74626ACBC6A9021EB1F88");
        vars.removeMessage("AF774550BCA74626ACBC6A9021EB1F88");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonC14ACFDEF17E458E90AD6072C93D78D8(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C14ACFDEF17E458E90AD6072C93D78D8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonC14ACFDEF17E458E90AD6072C93D78D8", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("C14ACFDEF17E458E90AD6072C93D78D8");
        vars.removeMessage("C14ACFDEF17E458E90AD6072C93D78D8");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton48D797375D1D421BB9F146AF8546E879(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 48D797375D1D421BB9F146AF8546E879");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton48D797375D1D421BB9F146AF8546E879", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("48D797375D1D421BB9F146AF8546E879");
        vars.removeMessage("48D797375D1D421BB9F146AF8546E879");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton943C8F5BEAAE44298C2572C727CF5614(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 943C8F5BEAAE44298C2572C727CF5614");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton943C8F5BEAAE44298C2572C727CF5614", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("943C8F5BEAAE44298C2572C727CF5614");
        vars.removeMessage("943C8F5BEAAE44298C2572C727CF5614");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton9C4187630C0A44B3829B2A9120B3EBC8(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9C4187630C0A44B3829B2A9120B3EBC8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9C4187630C0A44B3829B2A9120B3EBC8", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9C4187630C0A44B3829B2A9120B3EBC8");
        vars.removeMessage("9C4187630C0A44B3829B2A9120B3EBC8");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("em_crprod_paramStatus", "");
    xmlDocument.setParameter("em_crprod_MovemenNoClose", "");
    xmlDocument.setParameter("em_crprod_MovemenNoGen", "N");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton7901FF7DF9444013904A03D8F86E1B7E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7901FF7DF9444013904A03D8F86E1B7E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7901FF7DF9444013904A03D8F86E1B7E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7901FF7DF9444013904A03D8F86E1B7E");
        vars.removeMessage("7901FF7DF9444013904A03D8F86E1B7E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonB0DCB2771D744EAA8F75B2B6530CABF8(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B0DCB2771D744EAA8F75B2B6530CABF8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonB0DCB2771D744EAA8F75B2B6530CABF8", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("B0DCB2771D744EAA8F75B2B6530CABF8");
        vars.removeMessage("B0DCB2771D744EAA8F75B2B6530CABF8");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonB8E6E808CF5645669553E79F67936C5A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B8E6E808CF5645669553E79F67936C5A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonB8E6E808CF5645669553E79F67936C5A", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("B8E6E808CF5645669553E79F67936C5A");
        vars.removeMessage("B8E6E808CF5645669553E79F67936C5A");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonE0B23E3E8CEB4CD19E5EBC059E59ECBA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E0B23E3E8CEB4CD19E5EBC059E59ECBA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonE0B23E3E8CEB4CD19E5EBC059E59ECBA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("E0B23E3E8CEB4CD19E5EBC059E59ECBA");
        vars.removeMessage("E0B23E3E8CEB4CD19E5EBC059E59ECBA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton164D2FFC9D184D7DA75085943AB657A5(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 164D2FFC9D184D7DA75085943AB657A5");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton164D2FFC9D184D7DA75085943AB657A5", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("164D2FFC9D184D7DA75085943AB657A5");
        vars.removeMessage("164D2FFC9D184D7DA75085943AB657A5");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF3D2D70E07914B0A9D2023D95EE4F5EA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F3D2D70E07914B0A9D2023D95EE4F5EA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF3D2D70E07914B0A9D2023D95EE4F5EA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F3D2D70E07914B0A9D2023D95EE4F5EA");
        vars.removeMessage("F3D2D70E07914B0A9D2023D95EE4F5EA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD78F7B34CE624A778B8B064F96115122(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D78F7B34CE624A778B8B064F96115122");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD78F7B34CE624A778B8B064F96115122", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D78F7B34CE624A778B8B064F96115122");
        vars.removeMessage("D78F7B34CE624A778B8B064F96115122");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0483599196D442B0B7C4032DF3CD1496(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0483599196D442B0B7C4032DF3CD1496");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0483599196D442B0B7C4032DF3CD1496", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0483599196D442B0B7C4032DF3CD1496");
        vars.removeMessage("0483599196D442B0B7C4032DF3CD1496");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0A94232190EE46A2B4D13CBF30C8F423(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0A94232190EE46A2B4D13CBF30C8F423");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0A94232190EE46A2B4D13CBF30C8F423", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0A94232190EE46A2B4D13CBF30C8F423");
        vars.removeMessage("0A94232190EE46A2B4D13CBF30C8F423");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton5192F005F0524EE1A59AD3DCA8CDF4A3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5192F005F0524EE1A59AD3DCA8CDF4A3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5192F005F0524EE1A59AD3DCA8CDF4A3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("5192F005F0524EE1A59AD3DCA8CDF4A3");
        vars.removeMessage("5192F005F0524EE1A59AD3DCA8CDF4A3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonE74903303FE742EA93A4FA456DB444EC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E74903303FE742EA93A4FA456DB444EC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonE74903303FE742EA93A4FA456DB444EC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("E74903303FE742EA93A4FA456DB444EC");
        vars.removeMessage("E74903303FE742EA93A4FA456DB444EC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonDBF26D81854746A19B1F2B1F0B4C0952(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DBF26D81854746A19B1F2B1F0B4C0952");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDBF26D81854746A19B1F2B1F0B4C0952", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("DBF26D81854746A19B1F2B1F0B4C0952");
        vars.removeMessage("DBF26D81854746A19B1F2B1F0B4C0952");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCBD470CCB8274C60AB970DD9A8B9C9AD(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CBD470CCB8274C60AB970DD9A8B9C9AD");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCBD470CCB8274C60AB970DD9A8B9C9AD", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CBD470CCB8274C60AB970DD9A8B9C9AD");
        vars.removeMessage("CBD470CCB8274C60AB970DD9A8B9C9AD");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton1D22EE8C9F834A8E8051257DE39CBDB4(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1D22EE8C9F834A8E8051257DE39CBDB4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton1D22EE8C9F834A8E8051257DE39CBDB4", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("1D22EE8C9F834A8E8051257DE39CBDB4");
        vars.removeMessage("1D22EE8C9F834A8E8051257DE39CBDB4");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF41B28D5D2294D9B930D6D2E0C38BAEF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F41B28D5D2294D9B930D6D2E0C38BAEF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF41B28D5D2294D9B930D6D2E0C38BAEF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F41B28D5D2294D9B930D6D2E0C38BAEF");
        vars.removeMessage("F41B28D5D2294D9B930D6D2E0C38BAEF");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonE1781F4CF87B4E898740D640FC454507(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E1781F4CF87B4E898740D640FC454507");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonE1781F4CF87B4E898740D640FC454507", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("E1781F4CF87B4E898740D640FC454507");
        vars.removeMessage("E1781F4CF87B4E898740D640FC454507");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("AD_ORG_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "AD_ORG_ID", "A13D19673CE8431AAAB8184EFEEB17E3", "9DF5DA432CE94550AF408FDC6AC3490A", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportAD_ORG_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_YEAR_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "A202417EF3D6482FB1234045D1E6B9B3", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_YEAR_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Period_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "FB01B17020C942D488E298F8BC31FBCD", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Period_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonEF5BF59C53944CB6BBE5A6A4CACE7926(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EF5BF59C53944CB6BBE5A6A4CACE7926");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonEF5BF59C53944CB6BBE5A6A4CACE7926", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("EF5BF59C53944CB6BBE5A6A4CACE7926");
        vars.removeMessage("EF5BF59C53944CB6BBE5A6A4CACE7926");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonE18FC7C24D2647CE8F8BF88690E3A659(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E18FC7C24D2647CE8F8BF88690E3A659");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonE18FC7C24D2647CE8F8BF88690E3A659", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("E18FC7C24D2647CE8F8BF88690E3A659");
        vars.removeMessage("E18FC7C24D2647CE8F8BF88690E3A659");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("date_trx", "");
    xmlDocument.setParameter("date_trx_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("route", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonA37402A9673B4048A245E413D60263B9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A37402A9673B4048A245E413D60263B9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonA37402A9673B4048A245E413D60263B9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("A37402A9673B4048A245E413D60263B9");
        vars.removeMessage("A37402A9673B4048A245E413D60263B9");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonDFC1286B6CF8466F9E57A349A6BD6CA7(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DFC1286B6CF8466F9E57A349A6BD6CA7");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDFC1286B6CF8466F9E57A349A6BD6CA7", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("DFC1286B6CF8466F9E57A349A6BD6CA7");
        vars.removeMessage("DFC1286B6CF8466F9E57A349A6BD6CA7");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonC2D00205D53E4D2290EB232FE78F3667(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C2D00205D53E4D2290EB232FE78F3667");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonC2D00205D53E4D2290EB232FE78F3667", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("C2D00205D53E4D2290EB232FE78F3667");
        vars.removeMessage("C2D00205D53E4D2290EB232FE78F3667");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("authorizationcode", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B5C20B60DD3F4B4D93442FB7BE2DA6EA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("B5C20B60DD3F4B4D93442FB7BE2DA6EA");
        vars.removeMessage("B5C20B60DD3F4B4D93442FB7BE2DA6EA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonB88EEB979B6E4F92BAE22165681CA4AA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B88EEB979B6E4F92BAE22165681CA4AA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonB88EEB979B6E4F92BAE22165681CA4AA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("B88EEB979B6E4F92BAE22165681CA4AA");
        vars.removeMessage("B88EEB979B6E4F92BAE22165681CA4AA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonBD3E529180454E6FAEC68F644CFF068A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BD3E529180454E6FAEC68F644CFF068A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonBD3E529180454E6FAEC68F644CFF068A", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("BD3E529180454E6FAEC68F644CFF068A");
        vars.removeMessage("BD3E529180454E6FAEC68F644CFF068A");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton364900DC81134D3FBF819F85AFF5E7EA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 364900DC81134D3FBF819F85AFF5E7EA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton364900DC81134D3FBF819F85AFF5E7EA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("364900DC81134D3FBF819F85AFF5E7EA");
        vars.removeMessage("364900DC81134D3FBF819F85AFF5E7EA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton9EB67D7B8AFA4BD9BBA09BDA63EAA271(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9EB67D7B8AFA4BD9BBA09BDA63EAA271");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9EB67D7B8AFA4BD9BBA09BDA63EAA271", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9EB67D7B8AFA4BD9BBA09BDA63EAA271");
        vars.removeMessage("9EB67D7B8AFA4BD9BBA09BDA63EAA271");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Send", "N");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton87FCB47E59564ED8AB7B2F927205A912(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 87FCB47E59564ED8AB7B2F927205A912");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton87FCB47E59564ED8AB7B2F927205A912", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("87FCB47E59564ED8AB7B2F927205A912");
        vars.removeMessage("87FCB47E59564ED8AB7B2F927205A912");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton77FC3840AB4A4814B8247BA69B484F87(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 77FC3840AB4A4814B8247BA69B484F87");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton77FC3840AB4A4814B8247BA69B484F87", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("77FC3840AB4A4814B8247BA69B484F87");
        vars.removeMessage("77FC3840AB4A4814B8247BA69B484F87");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD76FECE66C5748B1A30275734FFAFD5B(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D76FECE66C5748B1A30275734FFAFD5B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD76FECE66C5748B1A30275734FFAFD5B", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D76FECE66C5748B1A30275734FFAFD5B");
        vars.removeMessage("D76FECE66C5748B1A30275734FFAFD5B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Quantity", "1");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton5DBC17C8408D4F878C4BD37962A7F9F8(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5DBC17C8408D4F878C4BD37962A7F9F8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5DBC17C8408D4F878C4BD37962A7F9F8", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("5DBC17C8408D4F878C4BD37962A7F9F8");
        vars.removeMessage("5DBC17C8408D4F878C4BD37962A7F9F8");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton8079F08464854BBEB4199DA1C0D7545C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8079F08464854BBEB4199DA1C0D7545C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton8079F08464854BBEB4199DA1C0D7545C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("8079F08464854BBEB4199DA1C0D7545C");
        vars.removeMessage("8079F08464854BBEB4199DA1C0D7545C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton2F09CAACE6E14C8FA56CE0ED4C7582B4(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 2F09CAACE6E14C8FA56CE0ED4C7582B4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton2F09CAACE6E14C8FA56CE0ED4C7582B4", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("2F09CAACE6E14C8FA56CE0ED4C7582B4");
        vars.removeMessage("2F09CAACE6E14C8FA56CE0ED4C7582B4");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton5523CFE2A7A149DF894C9CDD4A18DB88(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5523CFE2A7A149DF894C9CDD4A18DB88");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5523CFE2A7A149DF894C9CDD4A18DB88", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("5523CFE2A7A149DF894C9CDD4A18DB88");
        vars.removeMessage("5523CFE2A7A149DF894C9CDD4A18DB88");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonDF4E2B745B914942866105844E4ECFFC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DF4E2B745B914942866105844E4ECFFC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDF4E2B745B914942866105844E4ECFFC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("DF4E2B745B914942866105844E4ECFFC");
        vars.removeMessage("DF4E2B745B914942866105844E4ECFFC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFE7E37DEB4DF42F5853377E45E31A159(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FE7E37DEB4DF42F5853377E45E31A159");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFE7E37DEB4DF42F5853377E45E31A159", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FE7E37DEB4DF42F5853377E45E31A159");
        vars.removeMessage("FE7E37DEB4DF42F5853377E45E31A159");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton1715C3DFAAD94C1B8628D881A6EBBCFF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1715C3DFAAD94C1B8628D881A6EBBCFF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton1715C3DFAAD94C1B8628D881A6EBBCFF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("1715C3DFAAD94C1B8628D881A6EBBCFF");
        vars.removeMessage("1715C3DFAAD94C1B8628D881A6EBBCFF");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6FBD65B0FDB74D1AB07F0EADF18D48AE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6FBD65B0FDB74D1AB07F0EADF18D48AE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6FBD65B0FDB74D1AB07F0EADF18D48AE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6FBD65B0FDB74D1AB07F0EADF18D48AE");
        vars.removeMessage("6FBD65B0FDB74D1AB07F0EADF18D48AE");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton590066A49B89482786E6183DC0E99FE3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 590066A49B89482786E6183DC0E99FE3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton590066A49B89482786E6183DC0E99FE3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("590066A49B89482786E6183DC0E99FE3");
        vars.removeMessage("590066A49B89482786E6183DC0E99FE3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCE81B27EADC74667A59506719E70349A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CE81B27EADC74667A59506719E70349A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCE81B27EADC74667A59506719E70349A", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CE81B27EADC74667A59506719E70349A");
        vars.removeMessage("CE81B27EADC74667A59506719E70349A");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton135AFAA691B4481D85C9D913E4331101(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 135AFAA691B4481D85C9D913E4331101");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton135AFAA691B4481D85C9D913E4331101", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("135AFAA691B4481D85C9D913E4331101");
        vars.removeMessage("135AFAA691B4481D85C9D913E4331101");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton3D6ECD5657D645F4B82ABD5CC2A09BF3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3D6ECD5657D645F4B82ABD5CC2A09BF3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3D6ECD5657D645F4B82ABD5CC2A09BF3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("3D6ECD5657D645F4B82ABD5CC2A09BF3");
        vars.removeMessage("3D6ECD5657D645F4B82ABD5CC2A09BF3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton66C88DC622C14C8EA9272AFE367A01E6(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 66C88DC622C14C8EA9272AFE367A01E6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton66C88DC622C14C8EA9272AFE367A01E6", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("66C88DC622C14C8EA9272AFE367A01E6");
        vars.removeMessage("66C88DC622C14C8EA9272AFE367A01E6");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("ecscb_type_breakdown_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "ecscb_type_breakdown_id", "A3F625F6F2674D0FB4C74B44B342D217", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportecscb_type_breakdown_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }


    private void process9DB4D30BFC5144B9B431CB49DDE9270D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.KillSession().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7CB6B4D1ECCF4036B3F111D2CF11AADE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
params.put("mWarehouseId", strmWarehouseId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.MRPPurchaseCreateReservations().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process970EAD9B846648A7AB1F0CCA5058356C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strname = vars.getStringParameter("inpname");
params.put("name", strname);
String strimportauditinfo = vars.getStringParameter("inpimportauditinfo", "N");
params.put("importauditinfo", strimportauditinfo);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.service.db.ImportClientProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7EDBFEC35BDA4FF4AF05ED516CDAFB90(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.CreateCustomModule().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processABDFC8131D964936AD2EF7E0CED97FD9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.UpdateActuals().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3C386BC12832466790E50F2F8C5EBD85(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.materialmgmt.VariantAutomaticGenerationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processEFDBF909811544DAAE4E876AA781E5DC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.EndYearClose().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process107(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.materialmgmt.InventoryCountProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processCD7283DF804B449C97DA09446669EEEF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.ProcessBatch().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process85601427EAEE401FA0250FF0A6DD62EF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.assets.AssetLinearDepreciationMethodProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processA3FE1F9892394386A49FB707AA50A0FA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strrecalculateprices = vars.getStringParameter("inprecalculateprices", "N");
params.put("recalculateprices", strrecalculateprices);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.ConvertQuotationIntoOrder().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process136(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.VerifyBOM().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFB740AB61B0E42B198D2C88D3A0D0CE6(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strduedate = vars.getStringParameter("inpduedate");
params.put("duedate", strduedate);
String strfinPaymentPriorityId = vars.getStringParameter("inpfinPaymentPriorityId");
params.put("finPaymentPriorityId", strfinPaymentPriorityId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.UpdatePaymentPlan().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process58591E3E0F7648E4A09058E037CE49FC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strmProductId = vars.getStringParameter("inpmProductId");
params.put("mProductId", strmProductId);
String strmChValueId = vars.getStringParameter("inpmChValueId");
params.put("mChValueId", strmChValueId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.materialmgmt.VariantChDescUpdateProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process64B3FF29AC174F4B94538BD0A3CE1CD3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.costing.CostingMigrationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process23D1B163EC0B41F790CE39BF01DA320E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strmProductId = vars.getStringParameter("inpmProductId");
params.put("mProductId", strmProductId);
String strmAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");
params.put("mAttributesetinstanceId", strmAttributesetinstanceId);
String strreturned = vars.getNumericParameter("inpreturned");
params.put("returned", strreturned);
String strpricestd = vars.getNumericParameter("inppricestd");
params.put("pricestd", strpricestd);
String strcTaxId = vars.getStringParameter("inpcTaxId");
params.put("cTaxId", strcTaxId);
String strcReturnReasonId = vars.getStringParameter("inpcReturnReasonId");
params.put("cReturnReasonId", strcReturnReasonId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.RMInsertOrphanLine().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9EB2228A60684C0DBEC12D5CD8D85218(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.CalculatePromotions().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD85D5B5E368A49B1A6293BA4AE15F0F9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradClientId = vars.getStringParameter("inpadClientId");
params.put("adClientId", stradClientId);
String strexportauditinfo = vars.getStringParameter("inpexportauditinfo", "N");
params.put("exportauditinfo", strexportauditinfo);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.service.db.ExportClientProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF80808133362F6A013336781FCE0066(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.RMCreateInvoice().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF8081813219E68E013219ECFE930004(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strvalue = vars.getStringParameter("inpvalue");
params.put("value", strvalue);
String strname = vars.getStringParameter("inpname");
params.put("name", strname);
String strmProductCategoryId = vars.getStringParameter("inpmProductCategoryId");
params.put("mProductCategoryId", strmProductCategoryId);
String strproductiontype = vars.getStringParameter("inpproductiontype");
params.put("productiontype", strproductiontype);
String strqty = vars.getNumericParameter("inpqty");
params.put("qty", strqty);
String strcopyattribute = vars.getStringParameter("inpcopyattribute", "N");
params.put("copyattribute", strcopyattribute);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.SequenceProductCreate().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF808181324D007801324D2AE1130066(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdate = vars.getStringParameter("inpdate");
params.put("date", strdate);
String strstarttime = vars.getStringParameter("inpstarttime");
params.put("starttime", strstarttime);
String strendtime = vars.getStringParameter("inpendtime");
params.put("endtime", strendtime);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.CreateWorkEffort().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF808181326CD80501326CE906D70042(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.ValidateWorkEffort_ProductionRun().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF80818132A4F6AD0132A573DD7A0021(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.CreateStandards().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process2DDE7D3618034C38A4462B7F3456C28D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_BankStatementProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6BF16EFC772843AC9A17552AE0B26AB7(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_ReconciliationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0BDC2164ED3E48539FCEF4D306F29EFD(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_DoubtfulDebtProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5BE14AA10165490A9ADEFB7532F7FA94(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_AddPaymentFromJournal().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process58A9261BACEF45DDA526F29D8557272D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_BankStatementProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process15C8708DFC464C2D91286E59624FDD18(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcGlitemId = vars.getStringParameter("inpcGlitemId");
params.put("cGlitemId", strcGlitemId);
String strmProductId = vars.getStringParameter("inpmProductId");
params.put("mProductId", strmProductId);
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
params.put("cBpartnerId", strcBpartnerId);
String strcProjectId = vars.getStringParameter("inpcProjectId");
params.put("cProjectId", strcProjectId);
String strcCampaignId = vars.getStringParameter("inpcCampaignId");
params.put("cCampaignId", strcCampaignId);
String strcActivityId = vars.getStringParameter("inpcActivityId");
params.put("cActivityId", strcActivityId);
String strcSalesregionId = vars.getStringParameter("inpcSalesregionId");
params.put("cSalesregionId", strcSalesregionId);
String strcCostcenterId = vars.getStringParameter("inpcCostcenterId");
params.put("cCostcenterId", strcCostcenterId);
String struser1Id = vars.getStringParameter("inpuser1Id");
params.put("user1Id", struser1Id);
String struser2Id = vars.getStringParameter("inpuser2Id");
params.put("user2Id", struser2Id);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_TransactionModify().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process017312F51139438A9665775E3B5392A1(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_DoubtfulDebtRunProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6255BE488882480599C81284B70CD9B3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_PaymentProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processF68F2890E96D4D85A1DEF0274D105BCE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_TransactionProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process29D17F515727436DBCE32BC6CA28382B(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);
String strpaymentdate = vars.getStringParameter("inppaymentdate");
params.put("paymentdate", strpaymentdate);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_PaymentProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDE1B382FDD2540199D223586F6E216D0(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_AddPaymentFromJournalLine().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD16966FBF9604A3D91A50DC83C6EA8E3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_PaymentProposalProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF8080812E2F8EAE012E2F94CF470014(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_ReconciliationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF8080812F348A97012F349DC24F0007(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.ad_actionbutton.DeleteTransaction().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process66912CD2D96B494FA23F4AF2B7F795BA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.GeneratePurchaseSettlement().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processBED3CF78244147038E632AC2700C4F22(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.tenth.create_txt.ArchTransferTenthBankAustro().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process4380C4EBA98A4E7EB784ABC1360FE8EA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentUtilitiesRuminahuiBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process8388633AADD04FC487A0AEA775448333(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentProdubancoBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD10230FC59154A12ABC9FA6B4A9E4080(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcPeriodId = vars.getStringParameter("inpcPeriodId");
params.put("cPeriodId", strcPeriodId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ModifySalaryCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9E930637C9B44A73B0227D49AA30DD12(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradOrgId = vars.getStringParameter("inpadOrgId");
params.put("adOrgId", stradOrgId);
String strcCityId = vars.getStringParameter("inpcCityId");
params.put("cCityId", strcCityId);
String strcPeriodId = vars.getStringParameter("inpcPeriodId");
params.put("cPeriodId", strcPeriodId);
String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchVariationSalaryCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process71146C7A96774E58A772B98A8B1C6953(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePayrollPaymentRuminahuiBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processCD35DC8F54624AC0948C891C7F7E70A1(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentTenthProdubanco().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3B45D448EACA44FF9BD084C302459014(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);
String strcCostcenterId = vars.getStringParameter("inpcCostcenterId");
params.put("cCostcenterId", strcCostcenterId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.advanced.create_txt.ArchUtilitiesBankPichinchaTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3FAE7B1AB61F4E61B67481247AE8215F(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.Generate_Remission_Guide().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0AF06FA75CC348D98ECBD5FFFEF79330(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_xml.Formulary107_xml().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process4FB68828FA684DAAA1478926ED32B84C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);
String strcCostcenterId = vars.getStringParameter("inpcCostcenterId");
params.put("cCostcenterId", strcCostcenterId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchPaymentPichinchaBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process21C4B0035C5645109223814F0DD91AB5(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchTransferPayrollBankAustro().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0D9C391058AC4367BCC71DA7D39DE4C3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchTransferUtilitesBankAustro().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process418D9416C62B4087BE59A1B358910954(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);
String strsendno = vars.getStringParameter("inpsendno");
params.put("sendno", strsendno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.tenth.create_txt.ArchTenthCtralBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process837888BA221D47E6915FDE6DD361C1D9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_offline.fe_generation_offline().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process72380902AAEC47B4A493717B4D504E9E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.GenerateFE().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7CC8083871A2456BAC7B948F3510BC3C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.Generate_Movement().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process39774700D5B041BEB5DCC4CFF9E16CBE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);
String strcCostcenterId = vars.getStringParameter("inpcCostcenterId");
params.put("cCostcenterId", strcCostcenterId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.advanced.create_txt.ArchPayTenthBankPichinchaTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process437B1EE180984960A698FB8154DE5D35(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);
String stroutputtype = vars.getStringParameter("inpoutputtype");
params.put("outputtype", stroutputtype);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.UtilitiesCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDD60049F200E490BA823A5B3532F57B4(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcDoctypeId = vars.getStringParameter("inpcDoctypeId");
params.put("cDoctypeId", strcDoctypeId);
String strdatefrom = vars.getStringParameter("inpdatefrom");
params.put("datefrom", strdatefrom);
String strdateto = vars.getStringParameter("inpdateto");
params.put("dateto", strdateto);
String strfinFinancialAccountId = vars.getStringParameter("inpfinFinancialAccountId");
params.put("finFinancialAccountId", strfinFinancialAccountId);
String strsendno = vars.getStringParameter("inpsendno");
params.put("sendno", strsendno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.localization.ecuador.withholdings.create_xml.ArchProviderTransferTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process05E6E7C50BE3447392C9BC02EB86500D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.localization.ecuador.withholdings.ad_process.Sswh_ProcessWithholdingVoided().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process98EC8B6FBAC145CA926C4740A2C2B6FF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);
String strsendno = vars.getStringParameter("inpsendno");
params.put("sendno", strsendno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchPaymentCtralBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9337D1CEEC0647B888EC257259F025B2(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradOrgId = vars.getStringParameter("inpadOrgId");
params.put("adOrgId", stradOrgId);
String stratsType = vars.getStringParameter("inpatsType");
params.put("atsType", stratsType);
String strsemester = vars.getStringParameter("inpsemester");
params.put("semester", strsemester);
String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);
String strcPeriodId = vars.getStringParameter("inpcPeriodId");
params.put("cPeriodId", strcPeriodId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.localization.ecuador.withholdings.create_xml.Create_xml().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD93CCE4D4D954542BD7AA2F107404BAD(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentUtilitiesProdubanco().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD4F242B223A947238DEC0C1727C29D7B(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchPayrollGuayaquilBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process177A8D600E334A188E193EC8C647AED0(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.move.amortization.AssetLinearDepreciationMethodProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6F5F5FCC3C124629A02179A1D55DB636(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.move.ad_process.ProcessBatchDepreciationAssets().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3A53E5B4438A432EA7F48FD4A4FB9992(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.allocation.ad_process.change_state().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processED5960492A2C41929D59442D2C38F174(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.allocation.ad_process.ReturnAssetsStore().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process8483E826BD4A4F4FABE988B7EE7193EC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.allocation.ad_process.Approved_state().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processF57CB7A61C8F47E3AE2F19B740C2B72C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.tenth.create_txt.ArchTenthGuayaquilBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process36F2D08523FE4E4C9A8B8000CDEF2A39(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.localization.ecuador.finances.ad_process.Ssfi_InventoryCountProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process50A6708720CB4B7D9A62222AAFF04579(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strfecha = vars.getStringParameter("inpfecha");
params.put("fecha", strfecha);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.payroll.events.ad_process.PayrollEventsMissingInventoryDaily().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processF5B1A584BF824E3FAC430E032F020F4E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.closecash.background.Sccc_ProcessTransaction().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process364164C3FDC54156936DD179969F46B6(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.assets.changes.ad_process.ProcessAssetChanges().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process1BBCF97310864568BE34873F36850CC9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.assets.changes.ad_process.LoadField().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processCF5B8CCBDB3B46978A3A202D742E323D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.early.payment.ad_process.ArchivePaymentFortnightTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process93A46131F08141FA81C13B9D82A1F80C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strtypeofincome = vars.getStringParameter("inptypeofincome");
params.put("typeofincome", strtypeofincome);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.early.payment.create_txt.ArchPayrAdvPayRuminahuiBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5CF52155581B47CAAF5601D5C5DA93B3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.early.payment.create_txt.ArchPaymentFortnightPichinchaBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process00052E7428F8477CAACCE14830F8F43E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.localization.ecuador.withholdingssales.ad_process.ProcessWithholdingSale().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process01DA33DE7D4B443A8CBF5867B6B1C6C6(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.localization.importdata.loadvouchers.ad_process.ProcessTrx().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD244C9919E6747AD9DF9B43D1E1C6233(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.localization.importdata.loadvouchers.ad_process.CreateLines().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0C26D138283A4702AE8657D0B2755511(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.localization.importdata.loadvouchers.ad_process.UploadAuthPurchaseCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process1B5C7B74144344F7BF8154C73891E1F7(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.localization.importdata.loadvouchers.ad_process.LoadLinesAuthRefund().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process29604C7EF05B44C0AA36ACF4CF48528A(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.localization.importdata.loadvouchers.ad_process.CreateTransactions().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processC59D80628EAC461CA227D7ABAD089FA0(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strmOfferId = vars.getStringParameter("inpmOfferId");
params.put("mOfferId", strmOfferId);
String strqty = vars.getNumericParameter("inpqty");
params.put("qty", strqty);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.retail.discounts.AddPack().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processBBF5C85870774F0C89D1DCF8F7767F76(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.retail.config.process.IncludeAllProducts().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6278DF8D5F1D4091967DDB1733EB7622(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strobretcoProductlistId = vars.getStringParameter("inpobretcoProductlistId");
params.put("obretcoProductlistId", strobretcoProductlistId);
String strgenerateallimages = vars.getStringParameter("inpgenerateallimages", "N");
params.put("generateallimages", strgenerateallimages);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.retail.posterminal.utility.GenerateProductImages().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process864EAE677EE747ABB219FC888F16B44E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.imports.pricelist.ad_process.ProcessFileProductPL().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process17A8F88150734A46AB11C3E5E3AEAC71(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.imports.pricelist.ad_process.ProcessFile().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processAF99C0A0D75D490D80FEA24430E819FB(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.ad_process.OtherTaxIncomeLoadLines().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process60B20166BD984E8EBCB9ABCA90329BCA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strchangedate = vars.getStringParameter("inpchangedate");
params.put("changedate", strchangedate);
String strstartdate = vars.getStringParameter("inpstartdate");
params.put("startdate", strstartdate);
String strnewassetvalue = vars.getNumericParameter("inpnewassetvalue");
params.put("newassetvalue", strnewassetvalue);
String strusefullife = vars.getNumericParameter("inpusefullife");
params.put("usefullife", strusefullife);
String strdescription = vars.getStringParameter("inpdescription");
params.put("description", strdescription);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.asset.revaluation.ad_process.AssetRevaluation().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processA3D36D357A9F48DDB7507FCADC8465F3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.debit.collection.ad_process.SdcGeneratePayments().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process254354AEAC1645369FC71F81415993EB(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.loaddata.into.accounting.entries.ad_process.ProcessFileManualEntries().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process75BDBA6366F349EB84D46C0443F8B398(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.dinardap.advanced.ad_process.GenerateTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6BCC36C351F24D5F8ED72999F1C28220(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.inventory.blind.register.ad_process.ProcessedInventory().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processF873EC6D50E44F878E9505AF20394AC0(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.importdata.payments.ad_process.Simppys_ProcessPayments().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processAEC4E66A00274AEBBC4F1E61717A7C5F(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdateFrom = vars.getStringParameter("inpdateFrom");
params.put("dateFrom", strdateFrom);
String strdateTo = vars.getStringParameter("inpdateTo");
params.put("dateTo", strdateTo);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.dinardap.create_txt.ArchDinardapTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process00AB8AD197244C8EAA90B9D7A79ABCE4(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.importdata.payments.ad_process.Simppys_LoadLines().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process803D4F81300C464E96E2CB3F9854588B(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdate = vars.getStringParameter("inpdate");
params.put("date", strdate);
String strstarttime = vars.getStringParameter("inpstarttime");
params.put("starttime", strstarttime);
String strendtime = vars.getStringParameter("inpendtime");
params.put("endtime", strendtime);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.production.custom.date.ad_actionButton.CreateWorkEffort().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processC80B03ECDAE345F782E8A10493BCE2B8(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.discount.quota.salesinvoices.ad_process.LoadLines().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process33FAB6B9C73240B6829D03908C6CA448(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.discount.quota.salesinvoices.ad_process.ProcessLines().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processAF774550BCA74626ACBC6A9021EB1F88(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.discount.quota.salesinvoices.ad_process.Reactive().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processC14ACFDEF17E458E90AD6072C93D78D8(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.carnidem.production.ad_process.CompleteDocumentMeasureFPQ().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process48D797375D1D421BB9F146AF8546E879(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.retail.cashups.backgroundprocess.ad_process.SrcbpCashupsProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process943C8F5BEAAE44298C2572C727CF5614(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.projects.complement.ad_process.ProcessFileDetails().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9C4187630C0A44B3829B2A9120B3EBC8(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stremCrprodParamstatus = vars.getStringParameter("inpemCrprodParamstatus");
params.put("emCrprodParamstatus", stremCrprodParamstatus);
String stremCrprodMovemennoclose = vars.getStringParameter("inpemCrprodMovemennoclose", "N");
params.put("emCrprodMovemennoclose", stremCrprodMovemennoclose);
String stremCrprodMovemennogen = vars.getStringParameter("inpemCrprodMovemennogen", "N");
params.put("emCrprodMovemennogen", stremCrprodMovemennogen);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.carnidem.production.ad_process.CompleteDocumentMeasure().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7901FF7DF9444013904A03D8F86E1B7E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.projects.complement.ad_process.ProcessFile().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processB0DCB2771D744EAA8F75B2B6530CABF8(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.transfer.authorization.ad_process.SendEmailSupervisor().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processB8E6E808CF5645669553E79F67936C5A(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.carnidem.production.maintenance.ad_process.scma_processmaintenace().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processE0B23E3E8CEB4CD19E5EBC059E59ECBA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.workorder.update.price.ad_process.ValidateLine().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process164D2FFC9D184D7DA75085943AB657A5(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.inventory.adjustment.ad_process.SendEmailSupervisor().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processF3D2D70E07914B0A9D2023D95EE4F5EA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.projects.complement.ad_process.ProcessFileWorkforce().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD78F7B34CE624A778B8B064F96115122(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.workorder.simplified.ad_process.ProcessFile().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0483599196D442B0B7C4032DF3CD1496(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.postsale.movement.authorization.ad_process.TotalReturn().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0A94232190EE46A2B4D13CBF30C8F423(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.LeadProfilingRecordsGenerator().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5192F005F0524EE1A59AD3DCA8CDF4A3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.payments.partialpayment.ad_process.Sspp_ConfrimTransferPartialPayment().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processE74903303FE742EA93A4FA456DB444EC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.workorder.simplified.ad_process.ProcessFileConsolidation().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDBF26D81854746A19B1F2B1F0B4C0952(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.CaseSender().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processCBD470CCB8274C60AB970DD9A8B9C9AD(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.customizations.ecuapack.ad_process.Scmecu_InventoryCountProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process1D22EE8C9F834A8E8051257DE39CBDB4(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.localization.adjustment.inventory.pdv.ad_process.SendEmailSupervisorAuth().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processF41B28D5D2294D9B930D6D2E0C38BAEF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.notifications.mobileandroid.ad_Process.CreateNotificationsMobile().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processE1781F4CF87B4E898740D640FC454507(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradOrgId = vars.getStringParameter("inpadOrgId");
params.put("adOrgId", stradOrgId);
String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);
String strcPeriodId = vars.getStringParameter("inpcPeriodId");
params.put("cPeriodId", strcPeriodId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.xml.irbp.CreateXmlIrbp().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processEF5BF59C53944CB6BBE5A6A4CACE7926(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.payments.partialpayment.ad_process.SsppDownloadPaymentFile().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processE18FC7C24D2647CE8F8BF88690E3A659(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdateTrx = vars.getStringParameter("inpdateTrx");
params.put("dateTrx", strdateTrx);
String strroute = vars.getStringParameter("inproute");
params.put("route", strroute);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.dispatchmobile.ad_process.CompleteOrderRoute().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processA37402A9673B4048A245E413D60263B9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.postsale.movement.authorization.ad_process.SpareTransfer().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDFC1286B6CF8466F9E57A349A6BD6CA7(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.authorization.creditnote.ad_process.SendEmailSupervisor().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processC2D00205D53E4D2290EB232FE78F3667(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strauthorizationcode = vars.getStringParameter("inpauthorizationcode");
params.put("authorizationcode", strauthorizationcode);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.inventory.adjustment.ad_process.verifyPasswordSupervisor().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processB5C20B60DD3F4B4D93442FB7BE2DA6EA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.CaseUpdateSender().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processB88EEB979B6E4F92BAE22165681CA4AA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.app.order.ws.ad_process.Ssappor_ProcessLog().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processBD3E529180454E6FAEC68F644CFF068A(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.ecuador.asset.allocation.advanced.ad_process.Csaaa_AssetConciliation().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process364900DC81134D3FBF819F85AFF5E7EA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.imports.ad_process.UpdateFOB().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9EB67D7B8AFA4BD9BBA09BDA63EAA271(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strsend = vars.getStringParameter("inpsend", "N");
params.put("send", strsend);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.workorder.notifications.process.SendPrefecture().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process87FCB47E59564ED8AB7B2F927205A912(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.workorder.update.price.ad_process.ProcessLine().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process77FC3840AB4A4814B8247BA69B484F87(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.InviteSender().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD76FECE66C5748B1A30275734FFAFD5B(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strquantity = vars.getNumericParameter("inpquantity");
params.put("quantity", strquantity);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.postsale.movement.authorization.ad_process.PartialReturn().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5DBC17C8408D4F878C4BD37962A7F9F8(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.workorder.update.price.ad_process.UploadCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process8079F08464854BBEB4199DA1C0D7545C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.crm.visitplan.ad_process.Scrvro_CreateRoute().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process2F09CAACE6E14C8FA56CE0ED4C7582B4(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.closecash.ad_process.Unprocess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5523CFE2A7A149DF894C9CDD4A18DB88(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.creditcard.reconciliation.transaction.ad_process.SccrtGenerateCR().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDF4E2B745B914942866105844E4ECFFC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.ad_process.Sspr_AutomaticPayroll().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFE7E37DEB4DF42F5853377E45E31A159(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.financialcreditnote.sales.auto.ad_actionbutton.Scnsa_GenerateNC().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process1715C3DFAAD94C1B8628D881A6EBBCFF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.daily.closing.charge.ad_process.Sdcc_AutoCharge().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6FBD65B0FDB74D1AB07F0EADF18D48AE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.mrp.forecast.ad_actionButton.MRPManufacturingPlanProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process590066A49B89482786E6183DC0E99FE3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.mrp.ad_process.ProcessForecast().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processCE81B27EADC74667A59506719E70349A(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.carnidem.inheritance.attribute.ad_actionButton.CreateStandardsCustom().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process135AFAA691B4481D85C9D913E4331101(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.carnidem.breakdown.ad_process.DocActionCreateInventory().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3D6ECD5657D645F4B82ABD5CC2A09BF3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.carnidem.breakdown.ad_process.DocActionBreakdown().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process66C88DC622C14C8EA9272AFE367A01E6(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strecscbTypeBreakdownId = vars.getStringParameter("inpecscbTypeBreakdownId");
params.put("ecscbTypeBreakdownId", strecscbTypeBreakdownId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.carnidem.breakdown.ad_process.DocActionTypeBreakdown().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }


  public String getServletInfo() {
    return "Servlet ActionButton_Responser. This Servlet was made by Wad constructor";
  } // end of the getServletInfo() method

  private void processButtonHelper(HttpServletRequest request, HttpServletResponse response, VariablesSecureApp vars, OBError myMessage) 
     throws ServletException, IOException {
      advisePopUp(request, response, myMessage.getType(), myMessage.getTitle(), myMessage.getMessage());
  }
}
