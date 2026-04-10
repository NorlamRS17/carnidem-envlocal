
package org.openbravo.erpCommon.ad_callouts;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.ComboTableData;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.xmlEngine.XmlDocument;


public class ComboReloadsProcessHelper extends CalloutHelper {
  private static final long serialVersionUID = 1L;

  void printPage(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
   String strProcessId = vars.getStringParameter("inpadProcessId");
   
     if (strProcessId.equals("C1349783EEA54D9494B0034D6424B5D2")) {
       processC1349783EEA54D9494B0034D6424B5D2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("930BF970C16640E39049FE957E0F41F8")) {
       process930BF970C16640E39049FE957E0F41F8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7035CF2A33C14C2688A401932AB3A028")) {
       process7035CF2A33C14C2688A401932AB3A028(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("36415E726DE74F04BFAF026DD9038711")) {
       process36415E726DE74F04BFAF026DD9038711(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("785A5AE0739D404E8F1255B6E526B6F6")) {
       process785A5AE0739D404E8F1255B6E526B6F6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4DEA4E15C0EE42B3B94FBA5A95E3D426")) {
       process4DEA4E15C0EE42B3B94FBA5A95E3D426(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3548A9A058F2427ABFA7D664BBFAB9FC")) {
       process3548A9A058F2427ABFA7D664BBFAB9FC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5470B82CC23240498B755FC0346FB728")) {
       process5470B82CC23240498B755FC0346FB728(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E5F83B279855489F8D32BB6AA4F79A7C")) {
       processE5F83B279855489F8D32BB6AA4F79A7C(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A0A2EADA7A4241A18FAECAC16939A644")) {
       processA0A2EADA7A4241A18FAECAC16939A644(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A94E7F316A38495581C77CA8489AF511")) {
       processA94E7F316A38495581C77CA8489AF511(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B05F3316D8D64CD0B80B93562C78F9F1")) {
       processB05F3316D8D64CD0B80B93562C78F9F1(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BD7C961A29A643C68C18507AE933BECE")) {
       processBD7C961A29A643C68C18507AE933BECE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CD2D466E88E846AAAAC54357AFBA5A15")) {
       processCD2D466E88E846AAAAC54357AFBA5A15(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FC7AA594B6A54627B40CB584B0F3DC48")) {
       processFC7AA594B6A54627B40CB584B0F3DC48(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A822B5CBE10F4032803F0D7AC90261F6")) {
       processA822B5CBE10F4032803F0D7AC90261F6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E410F5E423CA4A168F1371BD38685F8A")) {
       processE410F5E423CA4A168F1371BD38685F8A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("9B2153B0D111459CAD4FAEC2CFB19F02")) {
       process9B2153B0D111459CAD4FAEC2CFB19F02(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CC2643C9E39A4B7E9B12B3A7111242C6")) {
       processCC2643C9E39A4B7E9B12B3A7111242C6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E2CA8D745BF64678812D86B8543F8D24")) {
       processE2CA8D745BF64678812D86B8543F8D24(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CBE8BB3D166B424DBA39E83398786CD8")) {
       processCBE8BB3D166B424DBA39E83398786CD8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0EB4081117314272908FD1E9A0EE0A31")) {
       process0EB4081117314272908FD1E9A0EE0A31(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("C6B5D6791BA14CBCA887E83BCF88CED5")) {
       processC6B5D6791BA14CBCA887E83BCF88CED5(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D16D6A8B6D064730B366017596B5316A")) {
       processD16D6A8B6D064730B366017596B5316A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("224")) {
       process224(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8E0340F567E946429D2050826A2D802E")) {
       process8E0340F567E946429D2050826A2D802E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("155")) {
       process155(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4842943F0E2F4E13B109258AC8553D63")) {
       process4842943F0E2F4E13B109258AC8553D63(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("DDDE5B867984455393A4B6A797B150BA")) {
       processDDDE5B867984455393A4B6A797B150BA(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("1B50BF1368CE4954BEBE59FDD3D33F7D")) {
       process1B50BF1368CE4954BEBE59FDD3D33F7D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0B2EE66A98CF4414A57AE564B791732A")) {
       process0B2EE66A98CF4414A57AE564B791732A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("55E8FC206F1145E1B0683D36DAD72DEC")) {
       process55E8FC206F1145E1B0683D36DAD72DEC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("EEEAD80E24FE4221BBFC086AD7E17AD8")) {
       processEEEAD80E24FE4221BBFC086AD7E17AD8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("6BF16EFC772843AC9A17552AE0B26AB7")) {
       process6BF16EFC772843AC9A17552AE0B26AB7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("AD2BC9898BC649FDB61CDF90DE178903")) {
       processAD2BC9898BC649FDB61CDF90DE178903(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A9D3EBC6D98F4306B34442C22AF6C73A")) {
       processA9D3EBC6D98F4306B34442C22AF6C73A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("175")) {
       process175(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800163")) {
       process800163(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("000EAB1966F845799D73250729AC0466")) {
       process000EAB1966F845799D73250729AC0466(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("AFC4E24AD1FD40DD86493B2F875074E2")) {
       processAFC4E24AD1FD40DD86493B2F875074E2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A80CF18E882E4946881E803876894B50")) {
       processA80CF18E882E4946881E803876894B50(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D6F97EBF983746488C841A50214A4639")) {
       processD6F97EBF983746488C841A50214A4639(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("58F6FA73AB3040D182068E7E5E6731FF")) {
       process58F6FA73AB3040D182068E7E5E6731FF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("9E930637C9B44A73B0227D49AA30DD12")) {
       process9E930637C9B44A73B0227D49AA30DD12(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800131")) {
       process800131(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("73964467E693462AAC51DEE309F1CA4B")) {
       process73964467E693462AAC51DEE309F1CA4B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A9C93D5456E3441F907ED96A113E0477")) {
       processA9C93D5456E3441F907ED96A113E0477(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("34081FAA0C434EB2B2484C345D49006F")) {
       process34081FAA0C434EB2B2484C345D49006F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("387D57585BE7414383A22C9158F106FA")) {
       process387D57585BE7414383A22C9158F106FA(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("017312F51139438A9665775E3B5392A1")) {
       process017312F51139438A9665775E3B5392A1(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7A9AD4BA75494258A48AFECBFF8D6E70")) {
       process7A9AD4BA75494258A48AFECBFF8D6E70(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("48EF850A2A4B47F8821F8D14031472ED")) {
       process48EF850A2A4B47F8821F8D14031472ED(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("112")) {
       process112(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("171D526C7A5447B186B7A0F87244E4FC")) {
       process171D526C7A5447B186B7A0F87244E4FC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("176")) {
       process176(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("251BED001BC541719824863D6F70FC10")) {
       process251BED001BC541719824863D6F70FC10(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FC40DEC74E12418FB7CA04A35A634419")) {
       processFC40DEC74E12418FB7CA04A35A634419(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7C15F94AD409487798D17975F3A8878A")) {
       process7C15F94AD409487798D17975F3A8878A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("C241F6154D5E4AD59158FE83AED6ECC0")) {
       processC241F6154D5E4AD59158FE83AED6ECC0(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FCB6C3AFA81A471CBE8954EE84EC9A1F")) {
       processFCB6C3AFA81A471CBE8954EE84EC9A1F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F666D842BF6C419FA927365261354B4E")) {
       processF666D842BF6C419FA927365261354B4E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("140")) {
       process140(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E7BA1DB91B04402DACEDAFD17A30C51F")) {
       processE7BA1DB91B04402DACEDAFD17A30C51F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("54D424B44CC342DC8CAC57880C25C195")) {
       process54D424B44CC342DC8CAC57880C25C195(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("154")) {
       process154(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("1C1F5462B9434703824460896EB435AE")) {
       process1C1F5462B9434703824460896EB435AE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800172")) {
       process800172(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4149C945342A4DA2A2CDC9C367B5B72A")) {
       process4149C945342A4DA2A2CDC9C367B5B72A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E928D18E8BD44BA596AE1436DB3FC90D")) {
       processE928D18E8BD44BA596AE1436DB3FC90D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("05E5587E09F449E5B0912B050C6DFACD")) {
       process05E5587E09F449E5B0912B050C6DFACD(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("073A24C010DB437CBE2F5045FF391C0C")) {
       process073A24C010DB437CBE2F5045FF391C0C(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("801783A2B5BB410496E956530DAA717C")) {
       process801783A2B5BB410496E956530DAA717C(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B5E465B4E4EA45218E4DE0CB98BE57E8")) {
       processB5E465B4E4EA45218E4DE0CB98BE57E8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("EFBD3CAED270415894992F58236E3241")) {
       processEFBD3CAED270415894992F58236E3241(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("2FE29E6E07404609818FD55BFC2AE7D2")) {
       process2FE29E6E07404609818FD55BFC2AE7D2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("23D1B163EC0B41F790CE39BF01DA320E")) {
       process23D1B163EC0B41F790CE39BF01DA320E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("237D91628E40439E90782002AED0C631")) {
       process237D91628E40439E90782002AED0C631(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A8674311F55D4AABB24EED50AB2BF9AB")) {
       processA8674311F55D4AABB24EED50AB2BF9AB(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("625231D462BC44128EE695A436E99CDE")) {
       process625231D462BC44128EE695A436E99CDE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("DC855AE32FDC4BE1A91C35D27A29DFAE")) {
       processDC855AE32FDC4BE1A91C35D27A29DFAE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("2DDE7D3618034C38A4462B7F3456C28D")) {
       process2DDE7D3618034C38A4462B7F3456C28D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7331756B5C104F5BAD66BBA0ABA7059E")) {
       process7331756B5C104F5BAD66BBA0ABA7059E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D00CA3CA241C4E5DB7565B8A370C8780")) {
       processD00CA3CA241C4E5DB7565B8A370C8780(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("6A91466FA8534422BF84C35F969D9FE7")) {
       process6A91466FA8534422BF84C35F969D9FE7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A347E177486848CDB548D5ECA1CFD6E6")) {
       processA347E177486848CDB548D5ECA1CFD6E6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("59E574810EFA4EB1A972290AD6820A48")) {
       process59E574810EFA4EB1A972290AD6820A48(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F126D2397DC34A4C8202D361A631A848")) {
       processF126D2397DC34A4C8202D361A631A848(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("DD82F60B07534F098A0256263E45BD4C")) {
       processDD82F60B07534F098A0256263E45BD4C(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D615D7D7DCE541E4849B88DAEEED8253")) {
       processD615D7D7DCE541E4849B88DAEEED8253(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B55BCEA485164065A78FA7B504DED744")) {
       processB55BCEA485164065A78FA7B504DED744(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("C1148D785B9C447BB759FF2F018B0082")) {
       processC1148D785B9C447BB759FF2F018B0082(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("91A8DDAABA474E97AA8F1F44E68B5526")) {
       process91A8DDAABA474E97AA8F1F44E68B5526(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("64DB09C127B042799CA2B2A85DDAA030")) {
       process64DB09C127B042799CA2B2A85DDAA030(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8BD1617B9D134461B37AA2A7E7C227C3")) {
       process8BD1617B9D134461B37AA2A7E7C227C3(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B53CBF732CAB4EBBBF2F4F620FE4A136")) {
       processB53CBF732CAB4EBBBF2F4F620FE4A136(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D3FE9C9093054C2194A6BBAB95D9DAB9")) {
       processD3FE9C9093054C2194A6BBAB95D9DAB9(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("1004400000")) {
       process1004400000(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("394EA06480474F49BF862F01FF069749")) {
       process394EA06480474F49BF862F01FF069749(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("1C482B1E8A2C42B0A0DF756BF985B89F")) {
       process1C482B1E8A2C42B0A0DF756BF985B89F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D5A2AA4829464AFD82ED83FB15BE9B92")) {
       processD5A2AA4829464AFD82ED83FB15BE9B92(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4C3A2C75B70F42A78B7B8DBF3FD15A6F")) {
       process4C3A2C75B70F42A78B7B8DBF3FD15A6F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8049DB455663436491DE46EF6E49B686")) {
       process8049DB455663436491DE46EF6E49B686(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("74A0DDCBA57D40738D6080C23BC6815B")) {
       process74A0DDCBA57D40738D6080C23BC6815B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("225")) {
       process225(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CC0E4572F5334B2AB8AE9DB977B44860")) {
       processCC0E4572F5334B2AB8AE9DB977B44860(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E041B544CC384252BDE836DB9B62D0E8")) {
       processE041B544CC384252BDE836DB9B62D0E8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B8EE5D31382E49EEBE2873A4131455CC")) {
       processB8EE5D31382E49EEBE2873A4131455CC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F731C58BD502460B893D30D3CD1FC4E2")) {
       processF731C58BD502460B893D30D3CD1FC4E2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("45A5EE58A3834A38BC256A831DD632D8")) {
       process45A5EE58A3834A38BC256A831DD632D8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E1781F4CF87B4E898740D640FC454507")) {
       processE1781F4CF87B4E898740D640FC454507(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("ECC738C8BD194D629534D94F616FBCA1")) {
       processECC738C8BD194D629534D94F616FBCA1(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F98A7A4B04E44ADEAF8CDBD7F9DB82F2")) {
       processF98A7A4B04E44ADEAF8CDBD7F9DB82F2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CA21963C478B4C40ACEDD491BE38283D")) {
       processCA21963C478B4C40ACEDD491BE38283D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("6255BE488882480599C81284B70CD9B3")) {
       process6255BE488882480599C81284B70CD9B3(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("6913EFC04AC445959CABAFE82885AB7B")) {
       process6913EFC04AC445959CABAFE82885AB7B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("58A9261BACEF45DDA526F29D8557272D")) {
       process58A9261BACEF45DDA526F29D8557272D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0BDC2164ED3E48539FCEF4D306F29EFD")) {
       process0BDC2164ED3E48539FCEF4D306F29EFD(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("08E912FC15D04889B05BA01C19B1390F")) {
       process08E912FC15D04889B05BA01C19B1390F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("C44B9B1B10574061BE489F8AF19E2202")) {
       processC44B9B1B10574061BE489F8AF19E2202(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B5170DE3EA0B4D4FBEAB4FD19BEB8A6A")) {
       processB5170DE3EA0B4D4FBEAB4FD19BEB8A6A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("58A443A11B674B559E99C311D7FCB1B9")) {
       process58A443A11B674B559E99C311D7FCB1B9(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("53D4CF8974724C9B92780120C6EAD0A0")) {
       process53D4CF8974724C9B92780120C6EAD0A0(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4BD8913AD8C94F0AA9F81BC1BFC5874B")) {
       process4BD8913AD8C94F0AA9F81BC1BFC5874B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BF50E41377E54EAA909BA4A385ADA280")) {
       processBF50E41377E54EAA909BA4A385ADA280(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("263E1E26870C4AFEB42E770BE40B2AA2")) {
       process263E1E26870C4AFEB42E770BE40B2AA2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("307503AE0B02489994E97490CBAD226B")) {
       process307503AE0B02489994E97490CBAD226B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("920F6279776E46AC9841A91AAB1D1942")) {
       process920F6279776E46AC9841A91AAB1D1942(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5DD1AA46AA584DED8A2C37026791AA61")) {
       process5DD1AA46AA584DED8A2C37026791AA61(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4FD1E6ACB05E466094255CE3D4FAA338")) {
       process4FD1E6ACB05E466094255CE3D4FAA338(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0D50EEB844B0495793D8D27E16B25D0E")) {
       process0D50EEB844B0495793D8D27E16B25D0E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B73F7827CF00490F9A5739EBCE8DC0CF")) {
       processB73F7827CF00490F9A5739EBCE8DC0CF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A171E9AE85D444338A245F080B01C0D5")) {
       processA171E9AE85D444338A245F080B01C0D5(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("33805987171F479692D8305EEB49ECB7")) {
       process33805987171F479692D8305EEB49ECB7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A096ED130B03469A9B57D986C50FB838")) {
       processA096ED130B03469A9B57D986C50FB838(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("108")) {
       process108(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("221")) {
       process221(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BEE1975A3DC34447A6C5E609193B441D")) {
       processBEE1975A3DC34447A6C5E609193B441D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("6816D2370C644C4B9D4EBDE2003A0560")) {
       process6816D2370C644C4B9D4EBDE2003A0560(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E810563A7A5E44929B487B20F9B19641")) {
       processE810563A7A5E44929B487B20F9B19641(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("36AA187AC62043C58E79F838E4A909AC")) {
       process36AA187AC62043C58E79F838E4A909AC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5E00B35F1C974EA99D02B366AFDD0437")) {
       process5E00B35F1C974EA99D02B366AFDD0437(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F7115FF7535F4B1B8932C20DD15996DF")) {
       processF7115FF7535F4B1B8932C20DD15996DF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5DC06629C50343499DA878CFBAE5AA3E")) {
       process5DC06629C50343499DA878CFBAE5AA3E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("99D49BDD337A4FF8B81231F7B2620163")) {
       process99D49BDD337A4FF8B81231F7B2620163(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0584DA2C77CB4122B2D7917BB421B302")) {
       process0584DA2C77CB4122B2D7917BB421B302(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("617430B1B667450A82C3FDB5C2499EFF")) {
       process617430B1B667450A82C3FDB5C2499EFF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5F9D9C4FF27844C0A0B997642D6481FF")) {
       process5F9D9C4FF27844C0A0B997642D6481FF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("466F6E93DA86438E8B3F9DB6C0734AA4")) {
       process466F6E93DA86438E8B3F9DB6C0734AA4(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F4267A2C73164CC2A3BF4553F9FD7135")) {
       processF4267A2C73164CC2A3BF4553F9FD7135(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("819CBE9A5E9F47318DEC8FD0BADE15C3")) {
       process819CBE9A5E9F47318DEC8FD0BADE15C3(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("C7705805B1314214BE74D4A3126DD7D8")) {
       processC7705805B1314214BE74D4A3126DD7D8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("2A74522453AF43CC957BDD62EEA748ED")) {
       process2A74522453AF43CC957BDD62EEA748ED(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A6D27B4A77D24AD08B25DCB70FF0B632")) {
       processA6D27B4A77D24AD08B25DCB70FF0B632(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("6B1DA206C72C45DB9AB70A60355BF1DE")) {
       process6B1DA206C72C45DB9AB70A60355BF1DE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("AA5ABC49CE994897A11DA59F251B3686")) {
       processAA5ABC49CE994897A11DA59F251B3686(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FB2950F39C204E778DCFD37758FD7E3A")) {
       processFB2950F39C204E778DCFD37758FD7E3A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("246FB8C734D04BB7834C3DFC4E4CA742")) {
       process246FB8C734D04BB7834C3DFC4E4CA742(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("354F3252BE3A45B6BD28AEA83FEBECDE")) {
       process354F3252BE3A45B6BD28AEA83FEBECDE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7799C2E0C0834EE3A813296C89D62EAF")) {
       process7799C2E0C0834EE3A813296C89D62EAF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("09CD97BDA0A140E4AAFA186D7E2E7B4B")) {
       process09CD97BDA0A140E4AAFA186D7E2E7B4B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E0439B18AA344099BAEC08FF982BBF7C")) {
       processE0439B18AA344099BAEC08FF982BBF7C(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("84EFF9F3A2B145D9A2AA2E7330B070FB")) {
       process84EFF9F3A2B145D9A2AA2E7330B070FB(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("EFCC77B8CE724BAFBCE55E5FE794FD72")) {
       processEFCC77B8CE724BAFBCE55E5FE794FD72(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FF8080812E2F8EAE012E2F94CF470014")) {
       processFF8080812E2F8EAE012E2F94CF470014(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("1C2C41FDF28A4A1684AD7A1D0E93FE37")) {
       process1C2C41FDF28A4A1684AD7A1D0E93FE37(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("EE5BEFFA40314A2CBA40DC01E20B6F88")) {
       processEE5BEFFA40314A2CBA40DC01E20B6F88(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("56CE5196C6CC48C59458809BA7C9A010")) {
       process56CE5196C6CC48C59458809BA7C9A010(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("85877950A7C44A3F886D8ABD87C2B7BF")) {
       process85877950A7C44A3F886D8ABD87C2B7BF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3C40792C947A47638FD6740F0FF8BCAA")) {
       process3C40792C947A47638FD6740F0FF8BCAA(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("159713CC430A4AAC98FADA0234E3758C")) {
       process159713CC430A4AAC98FADA0234E3758C(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("9337D1CEEC0647B888EC257259F025B2")) {
       process9337D1CEEC0647B888EC257259F025B2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("953824D9E596435A9F7F036E7346C0AF")) {
       process953824D9E596435A9F7F036E7346C0AF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5A2A0AF88AF54BB085DCC52FCC9B17B7")) {
       process5A2A0AF88AF54BB085DCC52FCC9B17B7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D351B9C7DFF04E4490A16FEB2121B6DE")) {
       processD351B9C7DFF04E4490A16FEB2121B6DE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A42A0463EF8F45EAB90F7B03F564A2E6")) {
       processA42A0463EF8F45EAB90F7B03F564A2E6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("DB0F3E41A5644534A37C4D0BE44F2E32")) {
       processDB0F3E41A5644534A37C4D0BE44F2E32(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CD4BB1F36A0F439994B2E43781C17B3F")) {
       processCD4BB1F36A0F439994B2E43781C17B3F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8481D546CE9B4C29BCB9E5A183827E9A")) {
       process8481D546CE9B4C29BCB9E5A183827E9A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("56518071D39043D6B0B87FFFE93E0E61")) {
       process56518071D39043D6B0B87FFFE93E0E61(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F68F2890E96D4D85A1DEF0274D105BCE")) {
       processF68F2890E96D4D85A1DEF0274D105BCE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("739CED3FF1054A5F9A69A243DDFD3E4E")) {
       process739CED3FF1054A5F9A69A243DDFD3E4E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D34546BAD8CD404A97AA7F49DB11A580")) {
       processD34546BAD8CD404A97AA7F49DB11A580(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("70959208A7D2454888AAEAC43FCC925F")) {
       process70959208A7D2454888AAEAC43FCC925F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800136")) {
       process800136(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("294AC292E3284BC2A62DC49D13262F96")) {
       process294AC292E3284BC2A62DC49D13262F96(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("63BB5E7F5B9643DFBA257F7F91C1009F")) {
       process63BB5E7F5B9643DFBA257F7F91C1009F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D234AE084F7040DCB66E281A4237FF99")) {
       processD234AE084F7040DCB66E281A4237FF99(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CDE0D5A454684752AD4E3AE241EF8821")) {
       processCDE0D5A454684752AD4E3AE241EF8821(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3BFC7A44E4CA4D51B2521EE14851F723")) {
       process3BFC7A44E4CA4D51B2521EE14851F723(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B7FCBB7DD7E24F7F81BA0B28E7A66E65")) {
       processB7FCBB7DD7E24F7F81BA0B28E7A66E65(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A4D8642E96FD4C56B00E416970861990")) {
       processA4D8642E96FD4C56B00E416970861990(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("059C7B83511F4CC4AA037026569AF57E")) {
       process059C7B83511F4CC4AA037026569AF57E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("EDDF4D2C9F624F3A950B46D23B87B48D")) {
       processEDDF4D2C9F624F3A950B46D23B87B48D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BCCB498B375F4189B48F4844C41DEADE")) {
       processBCCB498B375F4189B48F4844C41DEADE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E7C6834B50B34E9C93D17651673B6E1B")) {
       processE7C6834B50B34E9C93D17651673B6E1B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CB808DD623804DC58F144CC5D7D45FFB")) {
       processCB808DD623804DC58F144CC5D7D45FFB(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F70CBA510FBD4A41B4468490D82CCBDF")) {
       processF70CBA510FBD4A41B4468490D82CCBDF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5337EE4017214D7F90AF9DD00F2E6DE7")) {
       process5337EE4017214D7F90AF9DD00F2E6DE7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("DE363C2279934FE08CCF266B5CD4C296")) {
       processDE363C2279934FE08CCF266B5CD4C296(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E264309FF8244A94936502BF51829109")) {
       processE264309FF8244A94936502BF51829109(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("359817C12B3D4C03B77843C085393A13")) {
       process359817C12B3D4C03B77843C085393A13(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("AEAD04EDF29A4F87BC47E593EEBE813D")) {
       processAEAD04EDF29A4F87BC47E593EEBE813D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("18BBDA4443DB4CEC8287036B0CB2E586")) {
       process18BBDA4443DB4CEC8287036B0CB2E586(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3CD51DE34CCC4A9384D009B05B57D6CC")) {
       process3CD51DE34CCC4A9384D009B05B57D6CC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7404C291E97A4E95A335F6801976BE0B")) {
       process7404C291E97A4E95A335F6801976BE0B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("94B1F03F5CBA45A0920B11445E91D5D5")) {
       process94B1F03F5CBA45A0920B11445E91D5D5(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B3F74B7914AA4A49A409B0266C3EE8D4")) {
       processB3F74B7914AA4A49A409B0266C3EE8D4(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FF968F30B2664E9CA8AA0355411AA11B")) {
       processFF968F30B2664E9CA8AA0355411AA11B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8C0C61BB43FE43D1B5D6B7710D38AD8D")) {
       process8C0C61BB43FE43D1B5D6B7710D38AD8D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("9E01C2B943B340E8AA7192CF2A63B51D")) {
       process9E01C2B943B340E8AA7192CF2A63B51D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("2F4E363962094B46B5F17569F82063B7")) {
       process2F4E363962094B46B5F17569F82063B7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3FE1B414BBD44251872E6FBE86DBE82A")) {
       process3FE1B414BBD44251872E6FBE86DBE82A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("598CD3CFC58549CB9267C4B37D50D4F6")) {
       process598CD3CFC58549CB9267C4B37D50D4F6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3090494DFCE94CFCB847077C39CCEE47")) {
       process3090494DFCE94CFCB847077C39CCEE47(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E5DBC347EA364C2F901CC283C1CA39A7")) {
       processE5DBC347EA364C2F901CC283C1CA39A7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("80EB3DB8BA62441CB2D5AA17B5331AA1")) {
       process80EB3DB8BA62441CB2D5AA17B5331AA1(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8A696257BFD14401BC24EF0F04DAB72A")) {
       process8A696257BFD14401BC24EF0F04DAB72A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5498B90303C245F0B9FEF1D5021BC059")) {
       process5498B90303C245F0B9FEF1D5021BC059(response, vars, strTabId, windowId);
       return;
     }
    
    
    pageError(response);
  }
  
  
    private void processC1349783EEA54D9494B0034D6424B5D2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC1349783EEA54D9494B0034D6424B5D2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "346C1C93C1E747EB9E5CE7368909DD0B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process930BF970C16640E39049FE957E0F41F8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads930BF970C16640E39049FE957E0F41F8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "B6A2E8C9939A4998B7FD4A254E34497C", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7035CF2A33C14C2688A401932AB3A028(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7035CF2A33C14C2688A401932AB3A028';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "User1_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_CostCenter_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCostcenterId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process36415E726DE74F04BFAF026DD9038711(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads36415E726DE74F04BFAF026DD9038711';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inpdocbasetype", "inpdocbasetype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process785A5AE0739D404E8F1255B6E526B6F6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads785A5AE0739D404E8F1255B6E526B6F6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "EDED1A9C91E94F45938EFB7E2769BD9E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Posted", "2D725D380DD3459DBA63DB04A3A533C4", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4DEA4E15C0EE42B3B94FBA5A95E3D426(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4DEA4E15C0EE42B3B94FBA5A95E3D426';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "71188F0005494DA08311B4FFB2C5A993", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3548A9A058F2427ABFA7D664BBFAB9FC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3548A9A058F2427ABFA7D664BBFAB9FC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5470B82CC23240498B755FC0346FB728(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5470B82CC23240498B755FC0346FB728';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_ID", "", "7BF5312C69B44A94B6359830B612368D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE5F83B279855489F8D32BB6AA4F79A7C(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE5F83B279855489F8D32BB6AA4F79A7C';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocType_ID", "170", "BD708473F372400BB0DA80D3BB3AD510", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA0A2EADA7A4241A18FAECAC16939A644(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA0A2EADA7A4241A18FAECAC16939A644';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA94E7F316A38495581C77CA8489AF511(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA94E7F316A38495581C77CA8489AF511';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_ID", "110", "3AC0668B393D4B9BAF8BD3BE6F08CF01", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Product_ID", "1F603F334B704F53928B8DB908611657", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Product_Category_ID", "9F6C876E42E442E8A8FE45E229902A36", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB05F3316D8D64CD0B80B93562C78F9F1(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB05F3316D8D64CD0B80B93562C78F9F1';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inpdocbasetype", "inpdocbasetype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBD7C961A29A643C68C18507AE933BECE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBD7C961A29A643C68C18507AE933BECE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCD2D466E88E846AAAAC54357AFBA5A15(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCD2D466E88E846AAAAC54357AFBA5A15';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "07457FFB378D4EBD9B14A959884BDAA1", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFC7AA594B6A54627B40CB584B0F3DC48(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFC7AA594B6A54627B40CB584B0F3DC48';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "DAA0A9241DC24EE5B79984E69AA106C3", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA822B5CBE10F4032803F0D7AC90261F6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA822B5CBE10F4032803F0D7AC90261F6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inpdocbasetype", "inpdocbasetype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "DocBaseType", "E841509F2B4A403F86A50AEEF66B524B", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocbasetype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Posted", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE410F5E423CA4A168F1371BD38685F8A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE410F5E423CA4A168F1371BD38685F8A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "3FA87B0413B2493BB25EED2D4705CB7A", "87EBA06FBB854B25A88C3CF9FE96EF93", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId", "inp#adUserId", "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "c_bpartner_id", "98A1134A222F415D828BC2B8E876CD85", "A2DF3F45F3D0438BA92511EB97907DE2", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpinpoutputtype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "47CECD29D4CD4717A585A9ECA6CF11EF", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process9B2153B0D111459CAD4FAEC2CFB19F02(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads9B2153B0D111459CAD4FAEC2CFB19F02';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCC2643C9E39A4B7E9B12B3A7111242C6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCC2643C9E39A4B7E9B12B3A7111242C6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "95654FE227264D58B7E0852FC2D8FC99", "2B40CF028D3C4FB38319C634CEC8D8CE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE2CA8D745BF64678812D86B8543F8D24(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE2CA8D745BF64678812D86B8543F8D24';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "TRANSACTION_TYPE", "0DF92DC38A554E57927A2A01E8724686", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inptransactionType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "EXCLUDE", "6EC576DCC5074435B7778A676BAD78E0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpexclude";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "ASSET_TYPE", "6EC576DCC5074435B7778A676BAD78E0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpassetType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCBE8BB3D166B424DBA39E83398786CD8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCBE8BB3D166B424DBA39E83398786CD8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0EB4081117314272908FD1E9A0EE0A31(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0EB4081117314272908FD1E9A0EE0A31';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processC6B5D6791BA14CBCA887E83BCF88CED5(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC6B5D6791BA14CBCA887E83BCF88CED5';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Org_ID", "BBAEDF547C294409A8B2EF2B792F84AF", "15D50D97A9F5445CB3A18FA70344EF63", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "F9DA09AFCDA34C6A85FEB7B742AA77F0", "0F0D9E48398D4EF0B361F4B7C62979F7", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "A_Asset_Group_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaAssetGroupId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "EM_Ssam_Assettype", "6EC576DCC5074435B7778A676BAD78E0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpemSsamAssettype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD16D6A8B6D064730B366017596B5316A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD16D6A8B6D064730B366017596B5316A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "44C55EDC83864BD58E759EE52404EB26", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process224(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads224';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "175", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8E0340F567E946429D2050826A2D802E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8E0340F567E946429D2050826A2D802E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process155(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads155';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpinppaymentrule")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "PaymentRule", "195", "162", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inppaymentrule";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4842943F0E2F4E13B109258AC8553D63(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4842943F0E2F4E13B109258AC8553D63';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processDDDE5B867984455393A4B6A797B150BA(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsDDDE5B867984455393A4B6A797B150BA';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "95654FE227264D58B7E0852FC2D8FC99", "2B40CF028D3C4FB38319C634CEC8D8CE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process1B50BF1368CE4954BEBE59FDD3D33F7D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads1B50BF1368CE4954BEBE59FDD3D33F7D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "2AF3E0E04C9B41B89F193CC7FAB42DBB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0B2EE66A98CF4414A57AE564B791732A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0B2EE66A98CF4414A57AE564B791732A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "3668844D062A44338A0561FFEBCA6960", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process55E8FC206F1145E1B0683D36DAD72DEC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads55E8FC206F1145E1B0683D36DAD72DEC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_client_id", "129", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadClientId", "inpadClientId", "inp#userClient", "inp#userOrg")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_org_id", "276", "104", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "opportstatus", "1A136B80CA924A71B895B2BAA2D0EDC8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpopportstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "sales_stage", "8AEE970AF96B4F35BB80D53205A3BBCF", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpsalesStage";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processEEEAD80E24FE4221BBFC086AD7E17AD8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsEEEAD80E24FE4221BBFC086AD7E17AD8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process6BF16EFC772843AC9A17552AE0B26AB7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6BF16EFC772843AC9A17552AE0B26AB7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processAD2BC9898BC649FDB61CDF90DE178903(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsAD2BC9898BC649FDB61CDF90DE178903';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA9D3EBC6D98F4306B34442C22AF6C73A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA9D3EBC6D98F4306B34442C22AF6C73A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "B06611B34B894A4892D75E2E9DC6B432", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process175(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads175';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adLanguage")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Table_ID", "800022", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadTableId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800163(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800163';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "71188F0005494DA08311B4FFB2C5A993", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process000EAB1966F845799D73250729AC0466(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads000EAB1966F845799D73250729AC0466';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processAFC4E24AD1FD40DD86493B2F875074E2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsAFC4E24AD1FD40DD86493B2F875074E2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA80CF18E882E4946881E803876894B50(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA80CF18E882E4946881E803876894B50';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "4E075467EB874372A3E081E9D820C99A", "37E3A545D50D4B9EBDF76F0668BE5E0A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD6F97EBF983746488C841A50214A4639(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD6F97EBF983746488C841A50214A4639';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_prod_category", "163", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProdCategory";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_org_id", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_product_id", "1F603F334B704F53928B8DB908611657", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process58F6FA73AB3040D182068E7E5E6731FF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads58F6FA73AB3040D182068E7E5E6731FF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcYearId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ssph_tenth_settlement", "FFE5B4CD8D364932B4D96EFBD973500E", "7DF7DD0790BC4279920FB9D95261AFAF", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpssphTenthSettlement";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process9E930637C9B44A73B0227D49AA30DD12(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads9E930637C9B44A73B0227D49AA30DD12';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_city_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCityId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800131(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800131';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpstatus", "inpstatus")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "657B89EF105149F2B011CF8F5034FF92", "C5A7AABB91A440EBAA53A0222B99FF2F", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process73964467E693462AAC51DEE309F1CA4B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads73964467E693462AAC51DEE309F1CA4B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_Doctype_ID", "170", "FF80818131FFD8CE0131FFE73DC2002C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA9C93D5456E3441F907ED96A113E0477(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA9C93D5456E3441F907ED96A113E0477';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process34081FAA0C434EB2B2484C345D49006F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads34081FAA0C434EB2B2484C345D49006F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process387D57585BE7414383A22C9158F106FA(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads387D57585BE7414383A22C9158F106FA';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpmaWorkrequirementId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Production_id", "94FAA2F82AD64E2DA746E1D10F59C53B", "70F2C41E89524591B7F27726ACBE3711", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductionId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "MA_WorkRequirement_id", "FEF157FE83464C16BDE75AF6D4E0BDD6", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmaWorkrequirementId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpmaWorkrequirementId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_Uom_ID", "", "6E97A2CED8D74A078190FED1FC62D81B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcUomId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process017312F51139438A9665775E3B5392A1(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads017312F51139438A9665775E3B5392A1';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpemAprmProcess", "inpemAprmProcess")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7A9AD4BA75494258A48AFECBFF8D6E70(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7A9AD4BA75494258A48AFECBFF8D6E70';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process48EF850A2A4B47F8821F8D14031472ED(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads48EF850A2A4B47F8821F8D14031472ED';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process112(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads112';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FF8081812F06A183012F07323A2A001C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process171D526C7A5447B186B7A0F87244E4FC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads171D526C7A5447B186B7A0F87244E4FC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process176(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads176';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adLanguage")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Table_ID", "800022", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadTableId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process251BED001BC541719824863D6F70FC10(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads251BED001BC541719824863D6F70FC10';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "C4952089571E4142BB2A3089C128125E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "IsPosted", "2D725D380DD3459DBA63DB04A3A533C4", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpisposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFC40DEC74E12418FB7CA04A35A634419(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFC40DEC74E12418FB7CA04A35A634419';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "B06611B34B894A4892D75E2E9DC6B432", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7C15F94AD409487798D17975F3A8878A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7C15F94AD409487798D17975F3A8878A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "68E0C439D57D4081A57C979E1CC5F55F", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processC241F6154D5E4AD59158FE83AED6ECC0(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC241F6154D5E4AD59158FE83AED6ECC0';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFCB6C3AFA81A471CBE8954EE84EC9A1F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFCB6C3AFA81A471CBE8954EE84EC9A1F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF666D842BF6C419FA927365261354B4E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF666D842BF6C419FA927365261354B4E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "175", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process140(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads140';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FF8081812F06A183012F07323A2A001C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE7BA1DB91B04402DACEDAFD17A30C51F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE7BA1DB91B04402DACEDAFD17A30C51F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_user_id", "", "D91454EF9227416187A7FE264E957383", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "84DB718F20AA489CA69C2F30C330A6E4", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process54D424B44CC342DC8CAC57880C25C195(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads54D424B44CC342DC8CAC57880C25C195';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "AB84E0BFCA7442AEB32F740217F646DD", "FC9B5D2EFC904975BC20A1CC6216E40F", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process154(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads154';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpissotrx", "inpadOrgId", "inpadClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_PriceList_Version_ID", "", "26D8602C48004E1182B46310DF7015AE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmPricelistVersionId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process1C1F5462B9434703824460896EB435AE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads1C1F5462B9434703824460896EB435AE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "atindpo_postventa_id", "AE66BF9DD12445F49C8E78CF5081B5B4", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpatindpoPostventaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_bpartner_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800172(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800172';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpinpoutputtype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4149C945342A4DA2A2CDC9C367B5B72A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4149C945342A4DA2A2CDC9C367B5B72A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "44FE0D2089B3467AA5348E44B74C66EC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE928D18E8BD44BA596AE1436DB3FC90D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE928D18E8BD44BA596AE1436DB3FC90D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process05E5587E09F449E5B0912B050C6DFACD(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads05E5587E09F449E5B0912B050C6DFACD';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process073A24C010DB437CBE2F5045FF391C0C(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads073A24C010DB437CBE2F5045FF391C0C';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process801783A2B5BB410496E956530DAA717C(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads801783A2B5BB410496E956530DAA717C';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_BPartner_ID", "FE6B4F03532A4DECADDCD64E5FDFBC92", "8747D6A9B0D242B5AB7482DB6423ADD5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_user_id", "", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB5E465B4E4EA45218E4DE0CB98BE57E8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB5E465B4E4EA45218E4DE0CB98BE57E8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processEFBD3CAED270415894992F58236E3241(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsEFBD3CAED270415894992F58236E3241';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "110", "EDED1A9C91E94F45938EFB7E2769BD9E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process2FE29E6E07404609818FD55BFC2AE7D2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads2FE29E6E07404609818FD55BFC2AE7D2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "185F8664184A47B0BDC46266BA399B11", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process23D1B163EC0B41F790CE39BF01DA320E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads23D1B163EC0B41F790CE39BF01DA320E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpissotrx", "inpadClientId", "inpadOrgId", "inp#adClientId", "inpmProductId", "inpissotrx", "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_Tax_ID", "", "299FA667CF374AC5ACC74739C3251134", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcTaxId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process237D91628E40439E90782002AED0C631(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads237D91628E40439E90782002AED0C631';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "PARTNERID", "55752DFDB5D6479A95DA395B6916F188", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inppartnerid";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "E9873ECDE3434153B99B86D99179B050", "423A89222F514485BF474824525ADEB7", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_costcenter_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCostcenterId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA8674311F55D4AABB24EED50AB2BF9AB(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA8674311F55D4AABB24EED50AB2BF9AB';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_doctype_ID", "", "59D0BFCA70244A759DF360574891931C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process625231D462BC44128EE695A436E99CDE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads625231D462BC44128EE695A436E99CDE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "A514DF5BD8E74F9396B33747E56259C0", "AF4169FD57B2463BA23E33861BF58F02", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processDC855AE32FDC4BE1A91C35D27A29DFAE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsDC855AE32FDC4BE1A91C35D27A29DFAE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_Id", "", "39DEE2C0EE4D4D1F9DF945CCE46380FB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process2DDE7D3618034C38A4462B7F3456C28D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads2DDE7D3618034C38A4462B7F3456C28D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7331756B5C104F5BAD66BBA0ABA7059E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7331756B5C104F5BAD66BBA0ABA7059E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpfinIsreceipt", "inpfinIsreceipt")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Fin_Paymentmethod_ID", "", "FF80808130B107670130B118E5F60020", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpfinPaymentmethodId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD00CA3CA241C4E5DB7565B8A370C8780(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD00CA3CA241C4E5DB7565B8A370C8780';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_user_id", "", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process6A91466FA8534422BF84C35F969D9FE7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6A91466FA8534422BF84C35F969D9FE7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "E98C0C21878046818616A669D7A00B9B", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA347E177486848CDB548D5ECA1CFD6E6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA347E177486848CDB548D5ECA1CFD6E6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process59E574810EFA4EB1A972290AD6820A48(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads59E574810EFA4EB1A972290AD6820A48';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_PRODUCT_CATEGORY_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "USER2_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser2Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_WAREHOUSE_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF126D2397DC34A4C8202D361A631A848(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF126D2397DC34A4C8202D361A631A848';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_Id", "", "B06611B34B894A4892D75E2E9DC6B432", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processDD82F60B07534F098A0256263E45BD4C(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsDD82F60B07534F098A0256263E45BD4C';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "B7B80A1393C740F09B6D7D6E23F46153", "19D251D5F245481DA0EDAD5D8AD7B101", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD615D7D7DCE541E4849B88DAEEED8253(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD615D7D7DCE541E4849B88DAEEED8253';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB55BCEA485164065A78FA7B504DED744(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB55BCEA485164065A78FA7B504DED744';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_Id", "", "73B3A2568E334F5899ADC12D441DC7F5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_Campaign_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCampaignId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Product_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processC1148D785B9C447BB759FF2F018B0082(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC1148D785B9C447BB759FF2F018B0082';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "55CF2C913D74470BAE16F5BF288A7D48", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process91A8DDAABA474E97AA8F1F44E68B5526(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads91A8DDAABA474E97AA8F1F44E68B5526';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C561ACC971D842708CD8A6A5D07618F9", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C33222DB27D84183BE99E585BB463A92", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process64DB09C127B042799CA2B2A85DDAA030(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads64DB09C127B042799CA2B2A85DDAA030';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "E52883265B01420A8AAE2A976FA90B77", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8BD1617B9D134461B37AA2A7E7C227C3(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8BD1617B9D134461B37AA2A7E7C227C3';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "A41D78E0F41E47A9816DF2B5DB278083", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB53CBF732CAB4EBBBF2F4F620FE4A136(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB53CBF732CAB4EBBBF2F4F620FE4A136';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "EDED1A9C91E94F45938EFB7E2769BD9E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "posted", "2D725D380DD3459DBA63DB04A3A533C4", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD3FE9C9093054C2194A6BBAB95D9DAB9(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD3FE9C9093054C2194A6BBAB95D9DAB9';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process1004400000(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads1004400000';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "A3DCDE5EDD4A4403AC205B131F10F84D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process394EA06480474F49BF862F01FF069749(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads394EA06480474F49BF862F01FF069749';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_BPartner_ID", "FE6B4F03532A4DECADDCD64E5FDFBC92", "8747D6A9B0D242B5AB7482DB6423ADD5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process1C482B1E8A2C42B0A0DF756BF985B89F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads1C482B1E8A2C42B0A0DF756BF985B89F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpmWarehouseId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Locator_ID", "F846F235A5F04204882C08D9D490CE2E", "CC5361F243764DC3B600B3B2F9DE1EE0", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmLocatorId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_PRODUCT_CATEGORY_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_WAREHOUSE_ID", "", "E4BF32B3DEB344E894E50A8D61ED1EC1", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD5A2AA4829464AFD82ED83FB15BE9B92(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD5A2AA4829464AFD82ED83FB15BE9B92';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "A514DF5BD8E74F9396B33747E56259C0", "AF4169FD57B2463BA23E33861BF58F02", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ACCTSCHEMA_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_Costcenter_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCostcenterId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Client_ID", "", "D5CE1EFBE0BB49A3A8062EB5EE66E0DD", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4C3A2C75B70F42A78B7B8DBF3FD15A6F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4C3A2C75B70F42A78B7B8DBF3FD15A6F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8049DB455663436491DE46EF6E49B686(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8049DB455663436491DE46EF6E49B686';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inptypereason")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ssam_reason_alienate_id", "", "A248F645E46B432EACE740D54F571CAC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpssamReasonAlienateId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process74A0DDCBA57D40738D6080C23BC6815B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads74A0DDCBA57D40738D6080C23BC6815B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "174", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process225(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads225';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "174", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCC0E4572F5334B2AB8AE9DB977B44860(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCC0E4572F5334B2AB8AE9DB977B44860';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE041B544CC384252BDE836DB9B62D0E8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE041B544CC384252BDE836DB9B62D0E8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB8EE5D31382E49EEBE2873A4131455CC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB8EE5D31382E49EEBE2873A4131455CC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "89457EC166B6419E9969DFDE2F32A98B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF731C58BD502460B893D30D3CD1FC4E2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF731C58BD502460B893D30D3CD1FC4E2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process45A5EE58A3834A38BC256A831DD632D8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads45A5EE58A3834A38BC256A831DD632D8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_prod_category", "163", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProdCategory";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_org_id", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_product_id", "1F603F334B704F53928B8DB908611657", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE1781F4CF87B4E898740D640FC454507(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE1781F4CF87B4E898740D640FC454507';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "A202417EF3D6482FB1234045D1E6B9B3", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcYearId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcYearId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "FB01B17020C942D488E298F8BC31FBCD", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcPeriodId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processECC738C8BD194D629534D94F616FBCA1(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsECC738C8BD194D629534D94F616FBCA1';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF98A7A4B04E44ADEAF8CDBD7F9DB82F2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF98A7A4B04E44ADEAF8CDBD7F9DB82F2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "ASSET_TYPE", "6EC576DCC5074435B7778A676BAD78E0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpassetType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCA21963C478B4C40ACEDD491BE38283D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCA21963C478B4C40ACEDD491BE38283D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "3668844D062A44338A0561FFEBCA6960", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process6255BE488882480599C81284B70CD9B3(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6255BE488882480599C81284B70CD9B3';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpemAprmProcessPayment", "inpemAprmProcessPayment", "inpfinPaymentId", "inpemAprmProcessPayment", "inpfinPaymentId", "inpemAprmProcessPayment", "inpstatus", "inpemAprmProcessPayment")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "36972531DA994BB38ECB91993058282F", "575E470ABADB4C278132C957A78C47E3", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process6913EFC04AC445959CABAFE82885AB7B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6913EFC04AC445959CABAFE82885AB7B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "7665E6353013431ABA3420D8B732ACBD", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "2974F6CB467144A5859C4B82E12DEA03", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process58A9261BACEF45DDA526F29D8557272D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads58A9261BACEF45DDA526F29D8557272D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0BDC2164ED3E48539FCEF4D306F29EFD(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0BDC2164ED3E48539FCEF4D306F29EFD';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpemAprmProcess", "inpemAprmProcess")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process08E912FC15D04889B05BA01C19B1390F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads08E912FC15D04889B05BA01C19B1390F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "name_from", "163", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnameFrom";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "name_to", "163", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnameTo";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "m_warehouse_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processC44B9B1B10574061BE489F8AF19E2202(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC44B9B1B10574061BE489F8AF19E2202';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_city_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCityId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "4A2704DCBCBD42D6A5464AAF7CEE5F40", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB5170DE3EA0B4D4FBEAB4FD19BEB8A6A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB5170DE3EA0B4D4FBEAB4FD19BEB8A6A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "346C1C93C1E747EB9E5CE7368909DD0B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId", "inp#adUserId", "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "c_bpartner_id", "F571F46517A94DB5B2CB70A4EFA0650B", "8BC0BC0A4B494B0D913CB7BAEFEE5A2D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process58A443A11B674B559E99C311D7FCB1B9(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads58A443A11B674B559E99C311D7FCB1B9';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "A514DF5BD8E74F9396B33747E56259C0", "AF4169FD57B2463BA23E33861BF58F02", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process53D4CF8974724C9B92780120C6EAD0A0(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads53D4CF8974724C9B92780120C6EAD0A0';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_ID", "", "7BF5312C69B44A94B6359830B612368D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4BD8913AD8C94F0AA9F81BC1BFC5874B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4BD8913AD8C94F0AA9F81BC1BFC5874B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBF50E41377E54EAA909BA4A385ADA280(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBF50E41377E54EAA909BA4A385ADA280';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "55CF2C913D74470BAE16F5BF288A7D48", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process263E1E26870C4AFEB42E770BE40B2AA2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads263E1E26870C4AFEB42E770BE40B2AA2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_DocType_ID", "", "102", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process307503AE0B02489994E97490CBAD226B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads307503AE0B02489994E97490CBAD226B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_PriceList_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmPricelistId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process920F6279776E46AC9841A91AAB1D1942(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads920F6279776E46AC9841A91AAB1D1942';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "3AC0668B393D4B9BAF8BD3BE6F08CF01", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocType_ID", "170", "4A65C4764F6748AC971950214C4D326E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Org_ID", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Product_ID", "1F603F334B704F53928B8DB908611657", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Product_Category_ID", "9F6C876E42E442E8A8FE45E229902A36", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5DD1AA46AA584DED8A2C37026791AA61(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5DD1AA46AA584DED8A2C37026791AA61';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "D457D756A43F48F58F01C7FF6601BA6B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ssapi_trasactiontype_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpssapiTrasactiontypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "AssetType", "6EC576DCC5074435B7778A676BAD78E0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpassettype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "A_Asset_Group_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaAssetGroupId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4FD1E6ACB05E466094255CE3D4FAA338(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4FD1E6ACB05E466094255CE3D4FAA338';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C561ACC971D842708CD8A6A5D07618F9", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C33222DB27D84183BE99E585BB463A92", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0D50EEB844B0495793D8D27E16B25D0E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0D50EEB844B0495793D8D27E16B25D0E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "C61EBBA9D4D54D5399CC99F2BCA209DE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB73F7827CF00490F9A5739EBCE8DC0CF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB73F7827CF00490F9A5739EBCE8DC0CF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA171E9AE85D444338A245F080B01C0D5(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA171E9AE85D444338A245F080B01C0D5';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId", "inpuser1Id")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER2_ID", "7CCD8BE549594FEDA7A7EF54A9BDC87C", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser2Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "User1_ID", "F0636247C0194954AAD23B6715BF7557", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process33805987171F479692D8305EEB49ECB7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads33805987171F479692D8305EEB49ECB7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "FA40A7486E1548E89B357C76B872C5D5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA096ED130B03469A9B57D986C50FB838(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA096ED130B03469A9B57D986C50FB838';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process108(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads108';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcAcctschemaId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FDA7BA9355A6468DAF67E1C5288990A6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process221(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads221';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_BankAccount_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBankaccountId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBEE1975A3DC34447A6C5E609193B441D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBEE1975A3DC34447A6C5E609193B441D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process6816D2370C644C4B9D4EBDE2003A0560(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6816D2370C644C4B9D4EBDE2003A0560';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE810563A7A5E44929B487B20F9B19641(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE810563A7A5E44929B487B20F9B19641';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inpdocbasetype", "inpdocbasetype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process36AA187AC62043C58E79F838E4A909AC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads36AA187AC62043C58E79F838E4A909AC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5E00B35F1C974EA99D02B366AFDD0437(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5E00B35F1C974EA99D02B366AFDD0437';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF7115FF7535F4B1B8932C20DD15996DF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF7115FF7535F4B1B8932C20DD15996DF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "346C1C93C1E747EB9E5CE7368909DD0B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId", "inp#adUserId", "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_Bpartner_id", "F571F46517A94DB5B2CB70A4EFA0650B", "8BC0BC0A4B494B0D913CB7BAEFEE5A2D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5DC06629C50343499DA878CFBAE5AA3E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5DC06629C50343499DA878CFBAE5AA3E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpactivityType")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Activity_Status", "4AF7C49CF7A84AC084E23CDFAF1F6584", "DBF434EE3D954E28B02FCBB03869D060", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpactivityStatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process99D49BDD337A4FF8B81231F7B2620163(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads99D49BDD337A4FF8B81231F7B2620163';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "User1_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_COSTCENTER_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCostcenterId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0584DA2C77CB4122B2D7917BB421B302(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0584DA2C77CB4122B2D7917BB421B302';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "07457FFB378D4EBD9B14A959884BDAA1", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "BE610A5797874F5CBF0667E8519695EB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process617430B1B667450A82C3FDB5C2499EFF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads617430B1B667450A82C3FDB5C2499EFF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "363577EF034E49E4ABE445C3710D9A49", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5F9D9C4FF27844C0A0B997642D6481FF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5F9D9C4FF27844C0A0B997642D6481FF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process466F6E93DA86438E8B3F9DB6C0734AA4(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads466F6E93DA86438E8B3F9DB6C0734AA4';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF4267A2C73164CC2A3BF4553F9FD7135(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF4267A2C73164CC2A3BF4553F9FD7135';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcBpartnerId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_CommissionRun_ID", "DFDDC3CE016E4FFBA4E2A107842704C1", "E7A5D807010547DCB0B6414AF9F1C7A9", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCommissionrunId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "3668844D062A44338A0561FFEBCA6960", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "OutputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process819CBE9A5E9F47318DEC8FD0BADE15C3(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads819CBE9A5E9F47318DEC8FD0BADE15C3';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processC7705805B1314214BE74D4A3126DD7D8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC7705805B1314214BE74D4A3126DD7D8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "3AC0668B393D4B9BAF8BD3BE6F08CF01", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocType_ID", "170", "4A65C4764F6748AC971950214C4D326E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Org_ID", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Product_ID", "1F603F334B704F53928B8DB908611657", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Product_Category_ID", "9F6C876E42E442E8A8FE45E229902A36", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process2A74522453AF43CC957BDD62EEA748ED(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads2A74522453AF43CC957BDD62EEA748ED';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inpdocbasetype", "inpdocbasetype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA6D27B4A77D24AD08B25DCB70FF0B632(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA6D27B4A77D24AD08B25DCB70FF0B632';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "110", "D091C881E4F744C4826FE24EDA041A46", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process6B1DA206C72C45DB9AB70A60355BF1DE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6B1DA206C72C45DB9AB70A60355BF1DE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "84D3256F10154E1990577984E09190EF", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "slps_product_category_id", "DBA5DA92515141F09A3B6CB2AEE7F463", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpslpsProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "m_product_category_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processAA5ABC49CE994897A11DA59F251B3686(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsAA5ABC49CE994897A11DA59F251B3686';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFB2950F39C204E778DCFD37758FD7E3A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFB2950F39C204E778DCFD37758FD7E3A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_BPartner_ID", "FE6B4F03532A4DECADDCD64E5FDFBC92", "8747D6A9B0D242B5AB7482DB6423ADD5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process246FB8C734D04BB7834C3DFC4E4CA742(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads246FB8C734D04BB7834C3DFC4E4CA742';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process354F3252BE3A45B6BD28AEA83FEBECDE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads354F3252BE3A45B6BD28AEA83FEBECDE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_Id", "", "C25538F8AC6940CC98CDEF0264E2F7DD", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Product_Id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_Id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Product_Category_Id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7799C2E0C0834EE3A813296C89D62EAF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7799C2E0C0834EE3A813296C89D62EAF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId", "inp#adUserId", "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "c_bpartner_id", "98A1134A222F415D828BC2B8E876CD85", "A2DF3F45F3D0438BA92511EB97907DE2", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process09CD97BDA0A140E4AAFA186D7E2E7B4B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads09CD97BDA0A140E4AAFA186D7E2E7B4B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE0439B18AA344099BAEC08FF982BBF7C(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE0439B18AA344099BAEC08FF982BBF7C';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_WAREHOUSE_ID", "", "392181F42A674FF19ADB6D66E605ABB0", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpmWarehouseId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_LOCATOR_ID", "", "A8380FE6486A4A2BB277E87FD7A9796E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmLocatorId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_INVOICE_ID", "", "60251DE8DF374B6EB44741B3669B9384", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcInvoiceId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process84EFF9F3A2B145D9A2AA2E7330B070FB(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads84EFF9F3A2B145D9A2AA2E7330B070FB';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processEFCC77B8CE724BAFBCE55E5FE794FD72(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsEFCC77B8CE724BAFBCE55E5FE794FD72';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_PRODUCT_CATEGORY_ID", "163", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductCategoryId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_WAREHOUSE_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpinpmovementType")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "MOVEMENT_TYPE", "189", "17B919D43D254C1CB739726AD1D3E299", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmovementType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_DOCTYPE_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFF8080812E2F8EAE012E2F94CF470014(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFF8080812E2F8EAE012E2F94CF470014';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process1C2C41FDF28A4A1684AD7A1D0E93FE37(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads1C2C41FDF28A4A1684AD7A1D0E93FE37';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "3661EF23F0FB4424B62EDAC76010CF19", "80AEBDF1DE4C4D6B8E32222A78BFBADD", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processEE5BEFFA40314A2CBA40DC01E20B6F88(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsEE5BEFFA40314A2CBA40DC01E20B6F88';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "8336D9F5484E451E82A5F389737F42E9", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process56CE5196C6CC48C59458809BA7C9A010(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads56CE5196C6CC48C59458809BA7C9A010';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "E8DB521059424682BDE4C5C3D755AA6B", "138657D6AD5140D5B1474F20023B519B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process85877950A7C44A3F886D8ABD87C2B7BF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads85877950A7C44A3F886D8ABD87C2B7BF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "68E0C439D57D4081A57C979E1CC5F55F", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3C40792C947A47638FD6740F0FF8BCAA(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3C40792C947A47638FD6740F0FF8BCAA';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "FD6B72335EE2471585B9D99F01186B71", "758D95F7C85A4853B746A9ADE5D2F4C8", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_Id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process159713CC430A4AAC98FADA0234E3758C(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads159713CC430A4AAC98FADA0234E3758C';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpdocstatus", "inpdocstatus", "inpdocstatus", "inpdocstatus", "inpdocstatus")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "docstatus", "A59EA6E20C0D4F92BB96158C78BFA6FF", "07D8B925FC8B4383B6849027895E55B5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process9337D1CEEC0647B888EC257259F025B2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads9337D1CEEC0647B888EC257259F025B2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "36A5245EC9594447BAB449E060F4018E", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcYearId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Semester", "E604985995FA4165A296AD98DC495CBD", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpsemester";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Ats_Type", "053A5CA7D0074EE88F8EAA1BD65FB76E", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpatsType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process953824D9E596435A9F7F036E7346C0AF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads953824D9E596435A9F7F036E7346C0AF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5A2A0AF88AF54BB085DCC52FCC9B17B7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5A2A0AF88AF54BB085DCC52FCC9B17B7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpresStatus", "inpresStatus", "inpresStatus", "inpresStatus")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "RES_Action", "440DDA64A43F4799AAFF48BC86DC8F78", "1645143617E44289A08A1EA4D617A184", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpresAction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD351B9C7DFF04E4490A16FEB2121B6DE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD351B9C7DFF04E4490A16FEB2121B6DE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "c_doctype", "170", "876C54EBB7E94E18AC76B3A8AC4A1BDC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA42A0463EF8F45EAB90F7B03F564A2E6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA42A0463EF8F45EAB90F7B03F564A2E6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processDB0F3E41A5644534A37C4D0BE44F2E32(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsDB0F3E41A5644534A37C4D0BE44F2E32';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "A514DF5BD8E74F9396B33747E56259C0", "AF4169FD57B2463BA23E33861BF58F02", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCD4BB1F36A0F439994B2E43781C17B3F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCD4BB1F36A0F439994B2E43781C17B3F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "95654FE227264D58B7E0852FC2D8FC99", "2B40CF028D3C4FB38319C634CEC8D8CE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8481D546CE9B4C29BCB9E5A183827E9A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8481D546CE9B4C29BCB9E5A183827E9A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId", "inp#adUserId", "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_BPARTNER_ID", "F571F46517A94DB5B2CB70A4EFA0650B", "8BC0BC0A4B494B0D913CB7BAEFEE5A2D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process56518071D39043D6B0B87FFFE93E0E61(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads56518071D39043D6B0B87FFFE93E0E61';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF68F2890E96D4D85A1DEF0274D105BCE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF68F2890E96D4D85A1DEF0274D105BCE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "F671DDEA466D41A996F605590CB545BC", "FAE0D7C8A9D84FAFAE3C10CD5DCE6E30", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process739CED3FF1054A5F9A69A243DDFD3E4E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads739CED3FF1054A5F9A69A243DDFD3E4E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD34546BAD8CD404A97AA7F49DB11A580(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD34546BAD8CD404A97AA7F49DB11A580';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpfinIsreceipt", "inpfinIsreceipt")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Fin_Paymentmethod_ID", "", "FF80808130B107670130B118E5F60020", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpfinPaymentmethodId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process70959208A7D2454888AAEAC43FCC925F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads70959208A7D2454888AAEAC43FCC925F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800136(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800136';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FF8081812F06A183012F07323A2A001C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process294AC292E3284BC2A62DC49D13262F96(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads294AC292E3284BC2A62DC49D13262F96';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "95654FE227264D58B7E0852FC2D8FC99", "2B40CF028D3C4FB38319C634CEC8D8CE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process63BB5E7F5B9643DFBA257F7F91C1009F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads63BB5E7F5B9643DFBA257F7F91C1009F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD234AE084F7040DCB66E281A4237FF99(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD234AE084F7040DCB66E281A4237FF99';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adRoleId", "inp#adRoleId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "D9463AFD77E44F619D396C19BF9E6A15", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "reportType", "B82C3C28E51F4AA6B87D98E7ABBF92F0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpreporttype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCDE0D5A454684752AD4E3AE241EF8821(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCDE0D5A454684752AD4E3AE241EF8821';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Financial_Account_ID", "DF1CEA94B3564A33AFDB37C07E1CE353", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpfinancialAccountId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3BFC7A44E4CA4D51B2521EE14851F723(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3BFC7A44E4CA4D51B2521EE14851F723';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "95654FE227264D58B7E0852FC2D8FC99", "2B40CF028D3C4FB38319C634CEC8D8CE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB7FCBB7DD7E24F7F81BA0B28E7A66E65(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB7FCBB7DD7E24F7F81BA0B28E7A66E65';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "6DB1EEC0AE8C4274BA57530EABCD2878", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Posted", "3492EE1CA265471EA93B047E06701A90", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "117", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA4D8642E96FD4C56B00E416970861990(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA4D8642E96FD4C56B00E416970861990';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "95654FE227264D58B7E0852FC2D8FC99", "2B40CF028D3C4FB38319C634CEC8D8CE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process059C7B83511F4CC4AA037026569AF57E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads059C7B83511F4CC4AA037026569AF57E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processEDDF4D2C9F624F3A950B46D23B87B48D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsEDDF4D2C9F624F3A950B46D23B87B48D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_ORG_ID", "25E5CF7953E5498BAC58F6874A355653", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBCCB498B375F4189B48F4844C41DEADE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBCCB498B375F4189B48F4844C41DEADE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "44C55EDC83864BD58E759EE52404EB26", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE7C6834B50B34E9C93D17651673B6E1B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE7C6834B50B34E9C93D17651673B6E1B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCB808DD623804DC58F144CC5D7D45FFB(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCB808DD623804DC58F144CC5D7D45FFB';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcYearId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "65447418FD4D428CA025AC9AF26ADA21", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcPeriodId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF70CBA510FBD4A41B4468490D82CCBDF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF70CBA510FBD4A41B4468490D82CCBDF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5337EE4017214D7F90AF9DD00F2E6DE7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5337EE4017214D7F90AF9DD00F2E6DE7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processDE363C2279934FE08CCF266B5CD4C296(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsDE363C2279934FE08CCF266B5CD4C296';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE264309FF8244A94936502BF51829109(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE264309FF8244A94936502BF51829109';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adLanguage")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Table_ID", "800022", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadTableId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process359817C12B3D4C03B77843C085393A13(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads359817C12B3D4C03B77843C085393A13';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "95654FE227264D58B7E0852FC2D8FC99", "2B40CF028D3C4FB38319C634CEC8D8CE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processAEAD04EDF29A4F87BC47E593EEBE813D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsAEAD04EDF29A4F87BC47E593EEBE813D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "2AF3E0E04C9B41B89F193CC7FAB42DBB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process18BBDA4443DB4CEC8287036B0CB2E586(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads18BBDA4443DB4CEC8287036B0CB2E586';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3CD51DE34CCC4A9384D009B05B57D6CC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3CD51DE34CCC4A9384D009B05B57D6CC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "B06611B34B894A4892D75E2E9DC6B432", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_year_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcYearId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7404C291E97A4E95A335F6801976BE0B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7404C291E97A4E95A335F6801976BE0B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inpdocbasetype", "inpdocbasetype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process94B1F03F5CBA45A0920B11445E91D5D5(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads94B1F03F5CBA45A0920B11445E91D5D5';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Element_From", "2E446F7584B44E458C8087F1F50F469E", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpelementFrom";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Element_To", "2E446F7584B44E458C8087F1F50F469E", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpelementTo";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "A514DF5BD8E74F9396B33747E56259C0", "AF4169FD57B2463BA23E33861BF58F02", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Client_ID", "", "D5CE1EFBE0BB49A3A8062EB5EE66E0DD", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ACCTSCHEMA_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB3F74B7914AA4A49A409B0266C3EE8D4(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB3F74B7914AA4A49A409B0266C3EE8D4';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcBpartnerId", "inpdateFrom", "inpdateTo")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "sswoup_postventa_id", "BC85F89262A147B782C53EC258F623F3", "311345B2F0114E2EA6A12836071B4FB5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpsswoupPostventaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFF968F30B2664E9CA8AA0355411AA11B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFF968F30B2664E9CA8AA0355411AA11B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "TRANSACTION_TYPE", "0DF92DC38A554E57927A2A01E8724686", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inptransactionType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "BE9992E6123E49DB9A971C12ADF1E469", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "EXCLUDE", "6EC576DCC5074435B7778A676BAD78E0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpexclude";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "ASSET_TYPE", "6EC576DCC5074435B7778A676BAD78E0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpassetType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8C0C61BB43FE43D1B5D6B7710D38AD8D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8C0C61BB43FE43D1B5D6B7710D38AD8D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process9E01C2B943B340E8AA7192CF2A63B51D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads9E01C2B943B340E8AA7192CF2A63B51D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "A514DF5BD8E74F9396B33747E56259C0", "AF4169FD57B2463BA23E33861BF58F02", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process2F4E363962094B46B5F17569F82063B7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads2F4E363962094B46B5F17569F82063B7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3FE1B414BBD44251872E6FBE86DBE82A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3FE1B414BBD44251872E6FBE86DBE82A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "104C4488D9E54DF4810997B62E917E24", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process598CD3CFC58549CB9267C4B37D50D4F6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads598CD3CFC58549CB9267C4B37D50D4F6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "BE610A5797874F5CBF0667E8519695EB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3090494DFCE94CFCB847077C39CCEE47(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3090494DFCE94CFCB847077C39CCEE47';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_BPartner_ID", "FE6B4F03532A4DECADDCD64E5FDFBC92", "8747D6A9B0D242B5AB7482DB6423ADD5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBpartnerId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE5DBC347EA364C2F901CC283C1CA39A7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE5DBC347EA364C2F901CC283C1CA39A7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "73B3A2568E334F5899ADC12D441DC7F5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process80EB3DB8BA62441CB2D5AA17B5331AA1(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads80EB3DB8BA62441CB2D5AA17B5331AA1';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8A696257BFD14401BC24EF0F04DAB72A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8A696257BFD14401BC24EF0F04DAB72A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "E8DB521059424682BDE4C5C3D755AA6B", "138657D6AD5140D5B1474F20023B519B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpfinPaymentmethodId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Fin_Financial_Account_ID", "", "758B1753C048443D92E2C6BEC70A5DCB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpfinFinancialAccountId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpfinPaymentmethodId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "EM_Scca_Card_Type", "51124F668C644216B869F22310883669", "B43A948053794DA4B3C56E92117155FC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpemSccaCardType";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "FIN_PAYMENTMETHOD_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpfinPaymentmethodId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5498B90303C245F0B9FEF1D5021BC059(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5498B90303C245F0B9FEF1D5021BC059';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
}
