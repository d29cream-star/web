<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
s

header.masthead {
	display: none;
}

.row {
	height: 800px;
}

tr:hover {
	cursor: pointer;
}
</style>

<br />
<br />

<jsp:include page="../include/header.jsp" />

<!-- Begin Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<div class="panel-body">
				<h2 class="page-header">
					<span style="color: #52b1ff;">KH</span> 자유 게시판 <a
						href="http://127.0.0.1:8000/Kh/board-form.do"
						class="btn float-right"
						style="background-color: #52b1ff; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">글쓰기</a>
				</h2>
				<table class="table table-bordered table-hover">
					<thead>
						<tr
							style="background-color: #52b1ff; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
							<th width="100">번호</th>
							<th width="150">작성자</th>
							<th width="450">제목</th>
							<th width="200">작성일</th>
							<th width="100">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${ empty boards }">
								<tr>
									<th colspan="5">조회 결과가 존재하지 않습니다.</th>
								</tr>
							</c:when>
							<c:otherwise>

								<c:forEach items="${boards}" var="board">
									<tr style="color: #52b1ff;" class="board" id="1">
										<td>${board.boardId}</td>
										<td>${board.memberId}</td>
										<td style="color: #52d6ffcc;"><a href="http://127.0.0.1:8000/Kh/board-detail.do?boardId=${ board.boardId }">
										${board.boardTitle}&nbsp;</td>
										<td>${board.createDate}</td>
										<td>${board.count}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>

					</tbody>

				</table>
				<div id="search-area" class="form-group">
					<form action="" method="get">
						<select name="condition" class="form-control">
							<option value="writer">작성자</option>
							<option value="content">내용</option>
							<option value="title">제목</option>
						</select>
						<button type="submit" class="btn btn-block"
							style="background: #52b1ff; color: white">검색</button>
					</form>
				</div>
			</div>


			<div class="paging-area" align="center">

				<button class="btn btn-outline-primary" style="color: #52b1ff;"
					onclick="location.href='http://127.0.0.1:8000/Kh/boardlist.do?page=${ pageInfo.currentPage - 1}'">이전</button>

				<c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}"
					var="p">

					<button class="btn btn-outline-primary" style="color: #52b1ff;"
						onclick="location.href='http://127.0.0.1:8000/Kh/boardlist.do?page=${p}'">
						${p}</button>

				</c:forEach>

				<c:if test="${pageInfo.currentPage ne pageInfo.maxPage }">
					<button class="btn btn-outline-primary" style="color: #52b1ff;"
						onclick="location.href='http://127.0.0.1:8000/Kh/boardlist.do?page=${ pageInfo.currentPage+1 }'">다음</button>
				</c:if>

			</div>
		</div>
	</div>


</div>



<jsp:include page="../include/footer.jsp" />
