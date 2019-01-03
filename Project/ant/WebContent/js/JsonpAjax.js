$(function() {
	// 当键盘键被松开时发送Ajax获取数据
	$('#text').keyup(
			function() {
				var keywords = $(this).val();
				if (keywords == '') {
					$('#word').hide();
					return
				}
				;
				$.ajax({
					async : 'false',
					type : 'get',
					url : 'header/search',
					data : {
						'text' : keywords,
					},
					dataType : 'json',
					success : function(data) {
						$('#word').empty().show();
						$('#word').removeClass().addClass('wordBorder');
						if (data.length == 0) {
							$('#word').removeClass();	
						}
						for (var i = 0; i < data.length; i++) {
							$('#word').append(
									'<div class="click_work"><a href="searchByName?name='
											+ data[i] + '">' + data[i]
											+ '</a></div>');
						}
					},
					error : function() {
						$('#word').empty().show();
						$('#word').append(
								'<div class="click_work">Fail "' + keywords
										+ '"</div>');
					}
				})
			})
	/*
	 * $('#searchInput').focus(function(){ $
	 *  })
	 */
	// $('.click_work').click(function(){
	// alert('yes');
	// })
	// 点击搜索数据复制给搜索框
	// $(document).on('click','.click_work',function(){
	// var word = $(this).text();
	// $('#text').val(word);
	// $('#word').hide();
	// // $('#texe').trigger('click');触发搜索事件
	// })
})