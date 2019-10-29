/**
 * statisticsLive.js
 */

//SelectBox Detail 
$(function() {
	$('#place').change(function() {
		var placeSeq = $("#place option:selected").val()
		
		$("#detail").find('option').remove();
		$("#detail").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#floor").find('option').remove();
		$("#floor").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		
		$("#graphDiv > *").remove();
		
		var contents = "";
		
		contents +=	"<ul class='y-axis'>";
		contents +=	"<li><span>100%</span></li>";
		contents +=	"<li><span>80%</span></li>";
		contents +=	"<li><span>60%</span></li>";
		contents +=	"<li><span>40%</span></li>";
		contents +=	"<li><span>20%</span></li>";
		contents +=	"<li><span>0%</span></li>";
		contents +=	"</ul>";
		
		$("#graphDiv").append(contents);
		
		$.ajax({
			url : 'liveSelectDetail.do',
			data : {placeSeq:placeSeq},
		    type : 'post',
		    dataType: 'json',
			success : function(data){
				if (data.length >= 1) {					
					for (i = 0; i < data.length; i++) {
						$("#detail").append("<option value =" + data[i].detailSeq + ">" + data[i].detailName + "</option>")
					}
				}
		    }
		});	
	});
});

//SelectBox Floor 
$(function() {
	$('#detail').change(function() {
		var placeSeq = $("#place option:selected").val()
		var detailSeq = $("#detail option:selected").val()
		
		$("#floor").find('option').remove();
		$("#floor").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		
		$("#graphDiv > *").remove();
		
		var contents = "";
		
		contents +=	"<ul class='y-axis'>";
		contents +=	"<li><span>100%</span></li>";
		contents +=	"<li><span>80%</span></li>";
		contents +=	"<li><span>60%</span></li>";
		contents +=	"<li><span>40%</span></li>";
		contents +=	"<li><span>20%</span></li>";
		contents +=	"<li><span>0%</span></li>";
		contents +=	"</ul>";
		
		$("#graphDiv").append(contents);
			
		$.ajax({
			url : 'liveSelectFloor.do',
			data : {placeSeq:placeSeq, detailSeq:detailSeq},
		    type : 'post',
		    dataType: 'json',
			success : function(data){
				if (data.length >= 1) {					
					for (i = 0; i < data.length; i++) {
						$("#floor").append("<option value =" + data[i].floorSeq + ">" + data[i].floorName + "</option>")
					}
				}
		    }
		});	
	});
});

//SelectBox Gender 
$(function() {
	$('#floor').change(function() {
		var placeSeq = $("#place option:selected").val()
		var detailSeq = $("#detail option:selected").val()
		var floorSeq = $("#floor option:selected").val()
		
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		
		$("#graphDiv > *").remove();
		
		var contents = "";
		
		contents +=	"<ul class='y-axis'>";
		contents +=	"<li><span>100%</span></li>";
		contents +=	"<li><span>80%</span></li>";
		contents +=	"<li><span>60%</span></li>";
		contents +=	"<li><span>40%</span></li>";
		contents +=	"<li><span>20%</span></li>";
		contents +=	"<li><span>0%</span></li>";
		contents +=	"</ul>";
		
		$("#graphDiv").append(contents);
		
		$.ajax({
			url : 'liveSelectGender.do',
			data : {placeSeq:placeSeq, detailSeq:detailSeq, floorSeq:floorSeq},
		    type : 'post',
		    dataType: 'json',
			success : function(data){
				if (data.length >= 1) {					
					for (i = 0; i < data.length; i++) {
						$("#gender").append("<option value =" + data[i].genderNum + ">" + data[i].genderName + "</option>")
					}
				}
		    }
		});	
	});
});

// SelectBox All
$(function() {
	$('#gender').change(function() {
		var placeSeq = $("#place option:selected").val()
		var detailSeq = $("#detail option:selected").val()
		var floorSeq = $("#floor option:selected").val()
		var genderNum = $("#gender option:selected").val()
		
		$("#graphDiv > *").remove();
		
		var contents = "";
		
		contents +=	"<ul class='y-axis'>";
		contents +=	"<li><span>100%</span></li>";
		contents +=	"<li><span>80%</span></li>";
		contents +=	"<li><span>60%</span></li>";
		contents +=	"<li><span>40%</span></li>";
		contents +=	"<li><span>20%</span></li>";
		contents +=	"<li><span>0%</span></li>";
		contents +=	"</ul>";
		
		$("#graphDiv").append(contents);
		
		$.ajax({
			url : 'liveSelectAll.do',
			data : {placeSeq:placeSeq, detailSeq:detailSeq, floorSeq:floorSeq, genderNum:genderNum},
		    type : 'post',
		    dataType: 'json',
			success : function(data){
				if (data.length >= 1) {					
					for (i = 0; i < data.length; i++) {
						
						var contents = "";
						var trashAmount = Math.floor(data[i].trashAmount);
						
						if (trashAmount < 33) {
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].raspberrypiIp + "</strong></div>";
							contents += "<div class='value tooltips' data-toggle='tooltip' data-placement='top' style='height:100%'></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						} else if (trashAmount < 66 && trashAmount >= 33) {
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].raspberrypiIp + "</strong></div>";
							contents += "<div class='value tooltips' data-toggle='tooltip' data-placement='top' style='height:80%'></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						} else if (trashAmount < 99 && trashAmount >= 66) {
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].raspberrypiIp + "</strong></div>";
							contents += "<div class='value tooltips' data-toggle='tooltip' data-placement='top' style='height:60%'></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						} else if (trashAmount < 132 && trashAmount >= 99) {
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].raspberrypiIp + "</strong></div>";
							contents += "<div class='value tooltips' data-toggle='tooltip' data-placement='top' style='height:40%'></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						} else if (trashAmount < 170 && trashAmount >= 132) {
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].raspberrypiIp + "</strong></div>";
							contents += "<div class='value tooltips' data-toggle='tooltip' data-placement='top' style='height:20%'></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						} else {	
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].raspberrypiIp + "</strong></div>";
							contents += "<div class='value tooltips' data-toggle='tooltip' data-placement='top' style='height:00%'></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					}
				}
		    }
		});	
	});
});