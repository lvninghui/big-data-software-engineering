$(document)
		.ready(
				function() {
					var MaxInputs = 9;
					var InputsWrapper = $("#InputsWrapper");
					var AddButton = $("#AddMoreFileBox");
					var x = InputsWrapper.length;
					var FieldCount = 1;
					$(AddButton)
							.click(
									function(e) {
										if (x <= MaxInputs) {
											FieldCount++;
											$(InputsWrapper).children().last()
													.children().first()
													.removeAttr("id");
											$(InputsWrapper)
													.append(
															'<div><input type="text"  name="mytext[]" class="popup-input search-input"  id="last'
																	+ '" placeholder="请输入队员 '
																	+ FieldCount
																	+ ' 的学号"/><input type="button" rel="external nofollow" class="removeclass" value="删除"></div>');
											x++;
										}
										return false;
									});
					$("body").on("click", ".removeclass", function(e) {
						if (x > 1) {
							$(this).parent('div').remove();
							x--;
						}
						return false;
					})
					$("#text1")
							.on(
									"click",
									function() {
										window.scrollTo(0, 0);
										document.getElementById('light').style.display = 'block';
										document.getElementById('fade').style.display = 'block'

									});
					$("#text2")
							.on(
									"click",
									function() {
										document.getElementById('light').style.display = 'none';
										document.getElementById('fade').style.display = 'none'

									});
					$("#text").on("click", function() {
						document.fileForm.submit();
					});

					$('body')
							.on(
									"blur",
									"#last",
									function() {
										var studentId = $(this).val();
										if (window.XMLHttpRequest) {
											// IE7+, Firefox, Chrome, Opera,
											// Safari 浏览器执行代码
											xmlhttp = new XMLHttpRequest();
										} else {
											// IE6, IE5 浏览器执行代码
											xmlhttp = new ActiveXObject(
													"Microsoft.XMLHTTP");
										}
										/* 发送请求 */
										xmlhttp.open("post",
												"checkStudent?studentId="
														+ studentId, true);
										xmlhttp.send();

										xmlhttp.onreadystatechange = function() {
											if (xmlhttp.readyState == 4
													&& xmlhttp.status == 200) {

												var res = xmlhttp.responseText;
												if (res == "no") {
													document
															.getElementById("msg").innerHTML = "该同学还没有注册，请先注册！";
												} else {
													document
															.getElementById("msg").innerHTML = "";
												}
											}

										}
									});

				});