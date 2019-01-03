$(function() {
	var data1;
	var pageNum;
	var pageNo;
	$('.type_header').next().children().addClass("selected");
	$('.normal')
			.click(
					function() {
						// var
						// type_header=$(this).parent().parent().children('.type_header').text();
						// var type_detail=$(this).text();
						// var type=$('#types').children().$('.normal').text();
						// var type=$('#levels').$('.type_header').text();
						// var type=$('#timers').$('.selected').text();
						// alert(type_header+""+type_detail+""+text);
						if ($(this).parent().parent().attr('id') == 'ul') {
							// alert($(this).parent().parent().attr('id'));
							// alert('yes');
							// $(this).parent().parent().parent().children().children().removeClass().addClass('normal');
							$('#levels').children().children().removeClass()
									.addClass('normal');
							$(this).parent().parent().children().children()
									.removeClass().addClass('normal');
							$('#ipt').removeClass().addClass('selected1');
						} else {
							// if($(this).parent().parent().children().last().children().first().children().first().attr("id")=="ipt"){
							// $('#ipt').removeClass().addClass('normal');
							// }
							$('#ipt').removeClass().addClass('normal');
							$('#ul').children().children().removeClass()
									.addClass('normal');
							$(this).parent().parent().children().children()
									.removeClass().addClass('normal');

						}
						$(this).removeClass().addClass("selected");
						var types = [];// 定义数组
						// 取出所有housename的值，为数组赋值
						$('.selected').each(function() {
							types.push($(this).text())
						});
						pageNo = 1;
						// var types = $('.selected').text();
						// alert(types);
						$
								.ajax({
									async : 'false',
									url : 'search',
									data : {
										'types' : types
									},
									dataType : 'json',
									traditional : true,//阻止深度序列化，可以传递数组
									success : function(data) {
										data1 = data;
										pageNum = Math.ceil(data.length / 8);
										if(pageNum==0){
											pageNum=1
										}
										// alert("chengqiong");
										$('.activities').empty().show;
										$('.nextPage').empty().show;
										$('.lastPage').empty().show;
										$('.pageNo').empty().show;
										var length;
										if (data.length > 8) {
											length = 8;
										} else {
											length = data.length
										}
										for (var i = 0; i < length; i++) {
											// $('.activity_object').append('<div
											// class="click_work">'+data[i][0]
											// +'</div>');
											// $('.page').append('<div
											// class="click_work">'+data[i][0]
											// +'</div>');
											// $('.activities').append('<div
											// class="click_work">456</div>');
											$('.activities')
													.append(
															'<div class="activity_object">\
						                       <a href="activitydetail?actid='
																	+ data[i][0]
																	+ '"><img src="'
																	+ data[i][2]
																	+ '"></a>\
						                       <ul>\
						                          <li>\
						                              <a href="'
																	+ data[i][0]
																	+ '">'
																	+ data[i][1]
																	+ '</a>\
						                           </li>\
						                           <li>\
						                               <p id="grey">'
																	+ data[i][3]
																	+ '</p>\
						                           </li>\
						                            <li id="grey">参加人数:'
																	+ data[i][4]
																	+ '</li>\
						                        </ul>\
						                     </div>')

										}
										// if(pageNo<pageNum){
										// $('.page').append(
										// '<span>'+pageNo+'</span>/<span>'+pageNum+'</span>\
										// <div class="nextPage"><a
										// href="#">下一页</a></div>')}else{
										// $('.page').append(
										// '<span>'+pageNo+'</span>/<span>'+pageNum+'</span>')
										// }
										if (pageNo < pageNum) {
											$('.nextPage').append(
													'<a href="#" >下一页</a>')
										}
										$('.pageNo').append(
												'<span>' + pageNo
														+ '</span>/<span>'
														+ pageNum + '</span>')
									},
									error : function() {
										$('.activity_object').empty().show();
										/*
										 * $('#word').append('<div
										 * class="click_work">Fail "' + keywords + '"</div>');
										 */
									}

								})
					})
	$('.nextPage')
			.click(
					function() {
						// alert(pageNo);
						pageNo++;
						var length;
						if (pageNo == pageNum) {
							length = data1.length;
						} else {
							length = pageNo * 8;
						}
						// alert((pageNo-1)*8+""+length);
						for (i = (pageNo - 1) * 8; i < length; i++) {
							$('.activities').empty().show();
							$('.activities')
									.append(
											'<div class="activity_object">\
					                       <a href="student_activitydetail.jsp?actid='
													+ data1[i][0]
													+ '"><img src="'
													+ data1[i][2]
													+ '"></a>\
					                       <ul>\
					                          <li>\
					                              <a href="'
													+ data1[i][0]
													+ '">'
													+ data1[i][1]
													+ '</a>\
					                           </li>\
					                           <li>\
					                               <p id="grey">'
													+ data1[i][3]
													+ '</p>\
					                           </li>\
					                            <li id="grey">参加人数:'
													+ data1[i][4]
													+ '</li>\
					                        </ul>\
					                     </div>')

						}
						$('.nextPage').empty().show;
						$('.lastPage').empty().show;
						$('.pageNo').empty().show;
						$('.lastPage').append('<a href="#">上一页</a>')
						$('.pageNo').append(
								'<span>' + pageNo + '</span>/<span>' + pageNum
										+ '</span>')
						if (pageNo < pageNum) {
							$('.nextPage').append('<a href="#">下一页</a>')
						}
					});
				/*	$('.nextPage').click(function(){
						//alert("下一页");
					})*/
	$('.lastPage')
			.click(
					function() {
						// alert(data1[8][1]);
						pageNo--;
						var length;
						for (i = (pageNo - 1) * 8; i < pageNo * 8; i++) {
							$('.activities').empty().show();
							$('.activities')
									.append(
											'<div class="activity_object">\
					                       <a href="student_activitydetail.jsp?actid='
													+ data1[i][0]
													+ '"><img src="'
													+ data1[i][2]
													+ '"></a>\
					                       <ul>\
					                          <li>\
					                              <a href="'
													+ data1[i][0]
													+ '">'
													+ data1[i][1]
													+ '</a>\
					                           </li>\
					                           <li>\
					                               <p id="grey">'
													+ data1[i][3]
													+ '</p>\
					                           </li>\
					                            <li id="grey">参加人数:'
													+ data1[i][4]
													+ '</li>\
					                        </ul>\
					                     </div>')

						}
						$('.nextPage').empty().show;
						$('.lastPage').empty().show;
						$('.pageNo').empty().show;
						$('.nextPage').append('<a href="#">下一页</a>')
						$('.pageNo').append(
								'<span>' + pageNo + '</span>/<span>' + pageNum
										+ '</span>')
						if (pageNo > 1) {
							$('.lastPage').append('<a href="#">上一页</a>')
						}
					});
});
