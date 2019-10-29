/**
 * mapHome.js
 */
	//Page 
	function sendPage(idx) {
		var piPageNum = idx;
		location.href = "/mapping/?piPageNum="+piPageNum;
	}
	//checkAll
	$(function(){
		$("#checkAll").click(function(){
			if($("#checkAll").prop("checked")){
				$("input[name=piIP]").prop("checked",true);
			}else{
				$("input[name=piIP]").prop("checked",false);
			}
		})
	});
	//Mapping
	function fnGetdata(){
		var piArray =[];
		var cleanID = $('input:radio[name=cleanID]:checked').val() ;
        $('input:checkbox[name=piIP]:checked').each(function(i) { 
            piArray.push($(this).val());
        })
        
     	console.log(piArray);
	        $.ajax({
	        	url: '/mapping/reg'
	        	,type : 'post'
	        	,dataType : 'json'
	        	,data: {
	        		piValues: piArray,
	        		cleanID : cleanID
	        	},
	        	complete:function(data) {
	        		alert("매핑 성공");
	        		window.location.href = '/mapping/mappingList';
	        	},
	        	error : function(xhr, status, error) {
	                 alert("에러발생");
	                 window.location.href = '/mapping/';
	           }
        });
    }
	
