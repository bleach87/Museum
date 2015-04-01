/*    
    
    int pageNo = 0;
    int pageSize = 0;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      pageSize = PAGE_DEFAULT_SIZE;
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    
    ExhibitionDao exhibitionDao2 = (ExhibitionDao)this.getServletContext()
        .getAttribute("exhibitionDao");
    
    out.println("<ui>");
    
    
    for (Exhibition exlist : exhibitionDao2.selectList(pageNo, pageSize)) {
      out.println("  <li><a href='view?no=" + exlist.getNo() + "'>"
          + exlist.getTitle() + "</a></li>");
    }
    out.println("</ui>");
    */
    