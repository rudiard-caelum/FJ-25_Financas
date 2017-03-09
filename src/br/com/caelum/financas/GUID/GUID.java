package br.com.caelum.financas.GUID;

import java.util.UUID;

public class GUID {

	public static String GetGUID() {
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();
		return ("{" + randomUUIDString.toUpperCase() + "}");
	}
}
