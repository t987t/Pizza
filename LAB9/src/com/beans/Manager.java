package com.beans;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Order;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private String Mapper(int x)
    {
    	String ret;
    	if(x==1) ret="Order Placed";
    	else if(x==2) ret="Preparation";
    	else if(x==3) ret="Bake";
    	else if(x==4) ret="Quality Check";
    	else if(x==5) ret="Out for Delivery";
    	else ret="Delivered";
    	return ret;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Pending Orders</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Orders </h2>");
		writer.println("<table cellspacing=\"20px\">");
		writer.println("<form method='post'>");
		HashMap<Integer,User> chloro=PendingOrders.getOrders();
		for(Integer x: chloro.keySet())
		{
			Order obi=chloro.get(x).getCurrent_order();
			int y=obi.getState();
			writer.println("<tr>");
			writer.println("<td>");
			writer.println(x);
			writer.println("</td>");
			writer.println("<td>");
			writer.println(Mapper(y));
			writer.println("</td>");
			writer.println("<td>");
			Menu m=new Menu();
			ArrayList<Integer> moto=obi.getQuantities();
			int darth;
			for(darth=0;darth<obi.getPizzas().size();darth++)
			{
				writer.println(m.thisPizza(darth)+"("+moto.get(darth)+")");
				writer.println("</br>");
			}
			User usr=chloro.get(x);
			writer.println("<td>");
			writer.println(usr.getName());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(usr.getAddress());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(usr.getPhone_number());
			writer.println("</td>");
			writer.println("<td>");
			writer.println("<input type=\"submit\" name=\""+x+"\" value=\"Update\"/>");
			writer.println("</td>");
			writer.println("</tr>");
		}
		writer.println("</form>");
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		for(String y: request.getParameterMap().keySet())
		{
//			System.out.println(y);
			PendingOrders.changeOrder(Integer.parseInt(y));
		}
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Pending Orders</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2> Orders </h2>");
		writer.println("<table cellspacing=\"20px\">");
		writer.println("<form method='post'>");
		HashMap<Integer,User> chloro=PendingOrders.getOrders();
		for(Integer x: chloro.keySet())
		{
			Order obi=chloro.get(x).getCurrent_order();
			int y=obi.getState();
			writer.println("<tr>");
			writer.println("<td>");
			writer.println(x);
			writer.println("</td>");
			writer.println("<td>");
			writer.println(Mapper(y));
			writer.println("</td>");
			writer.println("<td>");
			Menu m=new Menu();
			ArrayList<Integer> moto=obi.getQuantities();
			int darth;
			for(darth=0;darth<obi.getPizzas().size();darth++)
			{
				writer.println(m.thisPizza(darth)+"("+moto.get(darth)+")");
				writer.println("</br>");
			}
			User usr=chloro.get(x);
			writer.println("<td>");
			writer.println(usr.getName());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(usr.getAddress());
			writer.println("</td>");
			writer.println("<td>");
			writer.println(usr.getPhone_number());
			writer.println("</td>");
			writer.println("<td>");
			writer.println("<input type=\"submit\" name=\""+x+"\" value=\"Update\"/>");
			writer.println("</td>");
			writer.println("</tr>");
		}
		writer.println("</form>");
		writer.println("</table>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
