/**
 * 
 */
function fnGetdata(){
		var piArray =[];
        $('input:checkbox[name=mapList]:checked').each(function(i) { 
            piArray.push($(this).val());
        })
        
     	console.log(piArray);
	        $.ajax({
	        	url: '/mapping/delete'
	        	,type : 'post'
	        	,dataType : 'json'
	        	,data: {
	        		deleteValues: piArray,
	        	},
	        	complete:function(data) {
	        		alert("삭제성공");
	        		window.location.href = '/mapping/mappingList';
	        	},
	        	error : function(xhr, status, error) {
	                 alert("에러발생");
	                 window.location.href = '/mapping/mappingList';
	           }
        });
    }
	$(function(){
		$("#checkAll").click(function(){
			if($("#checkAll").prop("checked")){
				$("input[name=mapList]").prop("checked",true);
			}else{
				$("input[name=mapList]").prop("checked",false);
			}
		})
	});