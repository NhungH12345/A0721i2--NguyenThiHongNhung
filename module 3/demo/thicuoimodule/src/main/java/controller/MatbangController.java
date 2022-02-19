package controller;

import model.Matbang;
import service.MatbangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "MatbangController", urlPatterns = "/matbang")
    public class MatbangController extends HttpServlet {
        private MatbangService matbangService= new MatbangService();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action= request.getParameter("action");
            switch (action){
                case "save":
                    String sid= request.getParameter("id");
                    int id= sid.isEmpty()? 0: Integer.parseInt(sid);
                    String dien_tich= request.getParameter("dien_tich");
                    String trang_thai= request.getParameter("trang_thai");
                    int tang= Integer.parseInt(request.getParameter("tang"));
                    String loai_van_phong= request.getParameter("loai_van_phong");
                    String gia_cho_thue= request.getParameter("gia_cho_thue");
                    String ngay_bat_dau= request.getParameter("ngay_bat_dau");
                    String ngay_ket_thuc= request.getParameter("ngay_ket_thuc");
                    Matbang matbang= new Matbang(id, dien_tich, trang_thai, tang, loai_van_phong, gia_cho_thue, ngay_bat_dau, ngay_ket_thuc);
                    matbangService.save(matbang);
                    break;
            }

            doGet(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action= request.getParameter("action");
            if(action== null) action= "";

            switch (action){
                case "edit":
                    int id= Integer.parseInt(request.getParameter("id"));
                    Matbang matbang= matbangService.get(id);
                    request.setAttribute("matbang", matbang);
                    request.getRequestDispatcher("/matbang/create.jsp").forward(request, response);
                    break;
                case "delete":
                    matbangService.delete(Integer.parseInt(request.getParameter("id")));
                default:
                    request.setAttribute("matbangs", matbangService.getAll());
                    request.getRequestDispatcher("/matbang/list.jsp").forward(request, response);
            }
        }
    }
