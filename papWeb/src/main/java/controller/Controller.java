package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.Funcionarios;
import model.ProjetoFuncionarios;
import model.Projetos;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns={"/Controller",
		"/listFuncs","/listProjs","/listProjFuncs",
		"/insertFunc","/insertProj","/insertProjFunc",
		"/selectFunc","/selectProj","/selectProjFunc","/selectFuncProj",
		"/updateFunc","/updateProj","/updateProjFunc",
		"/deleteFunc","/deleteProj","/deleteProjFunc",})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Funcionarios funcionario = new Funcionarios();
	Projetos projeto = new Projetos();
	ProjetoFuncionarios projetoFuncionarios = new ProjetoFuncionarios();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		dao.testarConexao();
		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/listFuncs")) {
			listFuncs(request,response);
		}else if(action.equals("/listProjs")) {
			listProjs(request,response);
		}else if(action.equals("/listProjFuncs")) {
			listProjFuncs(request,response);
		}else if(action.equals("/insertFunc")) {
			novoFunc(request,response);
		}else if(action.equals("/insertProj")) {
			novoProj(request,response);
		}else if(action.equals("/insertProjFunc")) {
			novoProjFunc(request,response);
		}else if(action.equals("/selectFunc")) {
			selectFunc(request,response);
		}else if(action.equals("/selectProj")) {
			selectProj(request,response);
		}else if(action.equals("/selectProjFunc")) {
			selectProjFunc(request,response);
		}else if(action.equals("/selectFuncProj")) {
			selectFuncProj(request,response);
		}else if(action.equals("/updateFunc")) {
			editarFunc(request,response);
		}else if(action.equals("/updateProj")) {
			editarProj(request,response);
		}else if(action.equals("/updateProjFunc")) {
			editarProjFunc(request,response);
		}else if(action.equals("/deleteFunc")) {
			removerFunc(request,response);
		}else if(action.equals("/deleteProj")) {
			removerProj(request,response);
		}else if(action.equals("/deleteProjFunc")) {
			removerProjFunc(request,response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	private void removerProjFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idProj = request.getParameter("idProj");
		String idFunc = request.getParameter("idFunc");
		projetoFuncionarios.setIdProjeto(idProj);
		projetoFuncionarios.setIdFuncionario(idFunc);
		
		dao.deletarFuncProj(projetoFuncionarios);
		
		ArrayList<ProjetoFuncionarios> lista = null;
		String id = request.getParameter("idProj");
		projetoFuncionarios.setIdProjeto(id);
		lista = dao.listarProjFuncs(projetoFuncionarios);
		request.setAttribute("projFuncs", lista);
		RequestDispatcher rd = request.getRequestDispatcher("projFuncs.jsp");
		rd.forward(request, response);	
	}

	private void removerProj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		projeto.setId(id);
		
		dao.deletarProjeto(projeto);
		
		ArrayList<Projetos> lista = null;
		lista = dao.listarProjetos();
		request.setAttribute("projetos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("projetos.jsp");
		rd.forward(request, response);
	}

	private void removerFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
        funcionario.setId(id);

        dao.deletarFuncionario(funcionario);
        
        ArrayList<Funcionarios> lista = null;
		lista = dao.listarFuncionarios();
		request.setAttribute("funcionarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funcionarios.jsp");
		rd.forward(request, response);
		
	}

	private void editarProjFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		projetoFuncionarios.setIdFuncionario(request.getParameter("idFunc"));
		projetoFuncionarios.setIdProjeto(request.getParameter("idProj"));
		projetoFuncionarios.setFuncao(request.getParameter("funcao"));
		dao.alterarFuncProj(projetoFuncionarios);
		
		ArrayList<ProjetoFuncionarios> lista = null;
		String id = request.getParameter("idProj");
		projetoFuncionarios.setIdProjeto(id);
		lista = dao.listarProjFuncs(projetoFuncionarios);
		request.setAttribute("projFuncs", lista);
		RequestDispatcher rd = request.getRequestDispatcher("projFuncs.jsp");
		rd.forward(request, response);
	}

	private void editarProj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		projeto.setId(request.getParameter("id"));
		projeto.setNome(request.getParameter("nome"));
		projeto.setDescricao(request.getParameter("descricao"));
		dao.alterarProjeto(projeto);
		
		ArrayList<Projetos> lista = null;
		lista = dao.listarProjetos();
		request.setAttribute("projetos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("projetos.jsp");
		rd.forward(request, response);
	}

	private void editarFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		funcionario.setId(request.getParameter("id"));
		funcionario.setNome(request.getParameter("nome"));
		dao.alterarFuncionario(funcionario);
        
        ArrayList<Funcionarios> lista = null;
		lista = dao.listarFuncionarios();
		request.setAttribute("funcionarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funcionarios.jsp");
		rd.forward(request, response);
		
	}

	private void selectProjFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		projetoFuncionarios.setIdFuncionario(request.getParameter("idFunc"));
		projetoFuncionarios.setIdProjeto(request.getParameter("idProj"));
		dao.selecionarProjFunc(projetoFuncionarios);
		
		request.setAttribute("idFunc", projetoFuncionarios.getIdFuncionario());
		request.setAttribute("idProj", projetoFuncionarios.getIdProjeto());
		request.setAttribute("nomeFunc", projetoFuncionarios.getNome());
		request.setAttribute("funcao", projetoFuncionarios.getFuncao());
		RequestDispatcher rd = request.getRequestDispatcher("editarProjFunc.jsp");
		rd.forward(request,response);
	}
	
	private void selectFuncProj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
        funcionario.setId(id);
        dao.selecionarFuncionario(funcionario);
        
        ArrayList<Projetos> lista = null;
		lista = dao.listarProjetos();
		request.setAttribute("projetos", lista);
        
        request.setAttribute("id", funcionario.getId());
        request.setAttribute("nome", funcionario.getNome());
        RequestDispatcher rd = request.getRequestDispatcher("novoProjFunc.jsp");
        rd.forward(request, response);
	}

	private void selectProj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		projeto.setId(id);
		dao.selecionarProjeto(projeto);
		
		request.setAttribute("id", projeto.getId());
		request.setAttribute("nome", projeto.getNome());
		request.setAttribute("descricao", projeto.getDescricao());
		RequestDispatcher rd = request.getRequestDispatcher("editarProjeto.jsp");
		rd.forward(request,response);
		
	}

	private void selectFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
        funcionario.setId(id);
        dao.selecionarFuncionario(funcionario);
        
        request.setAttribute("id", funcionario.getId());
        request.setAttribute("nome", funcionario.getNome());
        RequestDispatcher rd = request.getRequestDispatcher("editarFuncionario.jsp");
        rd.forward(request, response);
		
	}

	private void novoProjFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			projetoFuncionarios.setNome(request.getParameter("nomeFunc"));
			projetoFuncionarios.setFuncao(request.getParameter("funcao"));
			projetoFuncionarios.setIdFuncionario(request.getParameter("idFunc"));
			projetoFuncionarios.setIdProjeto(request.getParameter("idProj"));
			dao.inserirFuncProj(projetoFuncionarios);
			response.sendRedirect("index.html");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	private void novoProj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			projeto.setNome(request.getParameter("nome"));
			projeto.setDescricao(request.getParameter("descricao"));
			dao.inserirProjeto(projeto);
			response.sendRedirect("index.html");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	private void novoFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			funcionario.setNome(request.getParameter("nome"));
			dao.inserirFuncionario(funcionario);
			response.sendRedirect("index.html");
			}catch(Exception e) {
				System.out.println(e);
		}
	}

	private void listProjFuncs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProjetoFuncionarios> lista = null;
		String id = request.getParameter("id");
		projetoFuncionarios.setIdProjeto(id);
		lista = dao.listarProjFuncs(projetoFuncionarios);
		request.setAttribute("projFuncs", lista);
		RequestDispatcher rd = request.getRequestDispatcher("projFuncs.jsp");
		rd.forward(request, response);
		
	}

	private void listProjs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Projetos> lista = null;
		lista = dao.listarProjetos();
		request.setAttribute("projetos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("projetos.jsp");
		rd.forward(request, response);
		
	}

	protected void listFuncs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Funcionarios> lista = null;
		lista = dao.listarFuncionarios();
		request.setAttribute("funcionarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("funcionarios.jsp");
		rd.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
