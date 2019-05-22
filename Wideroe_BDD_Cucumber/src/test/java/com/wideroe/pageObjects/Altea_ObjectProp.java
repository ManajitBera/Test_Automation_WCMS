package com.wideroe.pageObjects;
public class Altea_ObjectProp {
	
	public static final String strURL = "https://uat3.resdesktop.altea.amadeus.com/app_ard/apf/init/login?SITE=EWFBEWFB&LANGUAGE=GB&MARKETS=ARDW_PDT_INTER";
	public static final String strUserName = "COGNIZ2";
	public static final String strPassword = "May@year19";
	
	public static final String strUserNameObj = "//input[@id='eusermanagement_login_logi_USER_ALIAS_id_input']";
	public static final String strPasswordObj = "//input[@id='eusermanagement_login_logi_PASSWORD_id_input']";
	public static final String strLogInBtnObj = "//button[@id='eusermanagement_login_logi_signin_id']";
	public static final String strTextInputObj = "//textarea[contains(@id,'_shellbridge_shellWindow_top_left_modeString_cmdPromptInput')]";
	public static final String strResponseObj = "(//pre[@id='responseCommand']/code)[count(//pre[@id='responseCommand']/code)]";
	public static final String strLogOutObj = "//a[@id='eusermanagement_logout_logo_logout_id']";
	public static final String strSignOutObj = "//button[@id='uicAlertBox_ok']";
	public static final String strFirstPassengerCheckBoxID = "passenger0";

}
