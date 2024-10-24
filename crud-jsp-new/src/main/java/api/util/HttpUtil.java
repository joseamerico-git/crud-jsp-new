package api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {

	public static final String URL_CERTIFICADO_SANDBOX = "https://api.sandbox.plugnotas.com.br/certificado";
	public static final String URL_ENVIO_NFE = "https://api.sandbox.plugnotas.com.br/nfe";
	public static final String CERTIFICADO = "https://api.sandbox.plugnotas.com.br/certificado";
	public static final String token = "2da392a6-79d2-4304-a8b7-959572c7e44d";

	public void getNfe() {

	}

	public static void postNfe(String jsonInputString) {

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(URL_ENVIO_NFE);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setConnectTimeout(10000);
			con.setReadTimeout(20000);

			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("x-api-key", token);

			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();

		} catch (MalformedURLException e) {
			System.out.println("The specified URL is malformed: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("An I/O error occurs: " + e.getMessage());
		}
	}
}
