<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>

header.masthead {
   display: none;
}   
.row{
	height : 800px;
}
tr:hover{
	cursor : pointer;
}

</style>

<br/><br/> 
 
   <jsp:include page="../include/header.jsp"/>

   <!-- Begin Page Content -->
   <div class="container">
      <div class="row">
         <div class="col-lg-1">
         </div>
         <div class="col-lg-10">
            <div class="panel-body">
            <h2 class="page-header"><span style="color: #52b1ff;">KH</span> 자유 게시판
               <a href="http://127.0.0.1:8000/Kh/board-form.do" class="btn float-right" style="background-color: #52b1ff; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">글쓰기</a>
            </h2>
               <table class="table table-bordered table-hover">
                  <thead>
	                  <tr style="background-color: #52b1ff; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
	                     <th width="100">번호</th>
	                     <th width="150">작성자</th>
	                     <th width="450">제목</th>
	                     <th width="200">작성일</th>
	                     <th width="100">조회수</th>
	                  </tr>
                  </thead>
                  <tbody>
	           
                    <tr style="color: #52b1ff;"
                        class="board"
                        id="1">
                        <td>
                        1
                        </td>
                        <td>
                        홍길동
                        </td>
                        <td style="color: #52d6ffcc;">
                        제목쓰 ㅎ &nbsp;
                        </td>
                        <td>
                        2026-11-26
                        </td>
                        <td>
                        0
                        </td>
                    </tr>    
 
                    
	        
                  </tbody>
                  
               </table> 
               <div id="search-area" class="form-group">
				<form action="" method="get">
					<select name="condition" class="form-control">
						<option value="writer">작성자</option>
						<option value="content">내용</option>
						<option value="title">제목</option>
					</select>
					<button type="submit" class="btn btn-block" style="background:#52b1ff; color:white">검색</button>
				</form>
		     </div>              
            </div>
                    
           
         <div class="paging-area" align="center" >
        	
        	
        
        	   
                <button 
                class="btn btn-outline-primary" style="color:#52b1ff;"
                onclick="">1</button>
        	   
                <button 
                class="btn btn-outline-primary" style="color:#52b1ff;"
                onclick="">1</button>
        	   
                <button 
                class="btn btn-outline-primary" style="color:#52b1ff;"
                onclick="">2</button>
        	   
                <button 
                class="btn btn-outline-primary" style="color:#52b1ff;"
                onclick="">3</button>
        	   
                <button 
                class="btn btn-outline-primary" style="color:#52b1ff;"
                onclick="">4</button>
        	   
                <button 
                class="btn btn-outline-primary" style="color:#52b1ff;"
                onclick="">5</button>

	        		
	        			
        	
        </div>
         </div>
      </div>
      
      
      
      
   </div>
   
     
     
   <jsp:include page="../include/footer.jsp"/>
    