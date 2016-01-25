package br.com.amil.predojo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;

import br.com.amil.predojo.FileRead_;
import br.com.amil.predojo.Rank;

/**
 * Servlet implementation class InputControl
 */
@MultipartConfig
@WebServlet("/InputControl")
public class InputControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InputControl() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse		
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,	
			HttpServletResponse response) throws ServletException, IOException {
		Part file = request.getPart("file");
		InputStream filecontent = file.getInputStream();
		 	
		FileRead_ filereRead_ = new FileRead_();
		BufferedReader br = new BufferedReader(new InputStreamReader(filecontent));
		List<Rank> rankGeral = filereRead_.armazenaPartida(br);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		 Gson gson = new Gson();
		 String json =gson.toJson(rankGeral);
		 response.getWriter().write(json);
	}

}
