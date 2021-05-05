$(".plusIcon").on("click",function(){
  var obj = $(this);
  if( obj.hasClass("glyphicon-plus") ){
    obj.hide();
    obj.next().show();            
    obj.parent().parent().next().show();
  }else{
     obj.hide();
     obj.prev().show();
     obj.parent().parent().next().hide();
  }
});