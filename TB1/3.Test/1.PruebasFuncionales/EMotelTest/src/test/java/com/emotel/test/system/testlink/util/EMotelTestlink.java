package com.emotel.test.system.testlink.util;

import java.net.URL;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;

public final class EMotelTestlink {

	private EMotelTestlink() {
		
	}
	
	public static boolean reportarCasoDePrueba(String urlTestlink, String keyTestlink, Integer idTestCaseInterno,
			Integer idTestCaseExterno, Integer idTestPlan, boolean paso, Integer idBuild, String nombreBuild,
			String mensaje, Integer idPlataforma, String nombrePlataforma) {
		boolean seEjecuto = false;
		try {
			URL testlinkUrl = new URL(urlTestlink);
			TestLinkAPI testlinkApi = new TestLinkAPI(testlinkUrl, keyTestlink);
			testlinkApi.reportTCResult(idTestCaseInterno, idTestCaseExterno, idTestPlan, 
					paso ? ExecutionStatus.PASSED : ExecutionStatus.FAILED, idBuild,
					nombreBuild, mensaje, false, "Ninguno", idPlataforma, nombrePlataforma, null, false);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return seEjecuto;
	}
}
