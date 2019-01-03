var ipt=document.getElementById('ipt');
  var ul=document.getElementById('ul');
  var lis=ul.children;
  ipt.onfocus=function(){
    ul.style.display='block';
  }
  ipt.onblur=function(){
    setTimeout(function(){
      ul.style.display='none';
    },200)
    
  }
  //模拟option点击事件
  for(var i=0;i<lis.length;i++){
    lis[i].onclick=function(){
      ipt.value=this.innerText;
    }
  }