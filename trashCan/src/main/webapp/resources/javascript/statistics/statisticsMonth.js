/**
 * statisticsMonth.js
 */

$(function() {
	$('#month').change(function() {
		$("#place").find('option').remove();
		$("#place").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#detail").find('option').remove();
		$("#detail").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#floor").find('option').remove();
		$("#floor").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		
		var month = $("#month option:selected").val();
		
		if ($("#month option:selected").text() == "--선택--") {
			$.ajax({
				url : 'monthSelectMonth.do',
				data : {},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
						
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {

							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].placeName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		} else {
			$.ajax({
				url : 'monthSelectPlace.do',
				data : {month:month},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							$("#place").append("<option value =" + data[i].placeSeq + ">" + data[i].placeName + "</option>")
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].placeName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);							
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		}
	});
});

// selcetBox Detail
$(function() {
	$('#place').change(function(){
		$("#detail").find('option').remove();
		$("#detail").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#floor").find('option').remove();
		$("#floor").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		
		var month = $("#month option:selected").val();
		var placeSeq = $("#place option:selected").val();
		
		if ($("#place option:selected").text() == "--선택--") {
			$.ajax({
				url : 'monthSelectPlace.do',
				data : {month:month},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].placeName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		} else {
			$.ajax({
				url : 'monthSelectDetail.do',
				data : {month:month, placeSeq:placeSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							$("#detail").append("<option value =" + data[i].detailSeq + ">" + data[i].detailName + "</option>")
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].detailName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		}
	});
});

// selcetBox Floor
$(function() {
	$('#detail').change(function(){
		$("#floor").find('option').remove();
		$("#floor").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		
		var month = $("#month option:selected").val();
		var placeSeq = $("#place option:selected").val();
		var detailSeq = $("#detail option:selected").val();
		
		if ($("#detail option:selected").text() == "--선택--") {
			$.ajax({
				url : 'monthSelectDetail.do',
				data : {month:month, placeSeq:placeSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].detailName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		} else {
			$.ajax({
				url : 'monthSelectFloor.do',
				data : {month:month, placeSeq:placeSeq, detailSeq:detailSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							$("#floor").append("<option value =" + data[i].floorSeq + ">" + data[i].floorName + "</option>")
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].floorName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		}
	});
});

// selcetBox Gender
$(function() {
	$('#floor').change(function(){
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		
		var month = $("#month option:selected").val();
		var placeSeq = $("#place option:selected").val();
		var detailSeq = $("#detail option:selected").val();
		var floorSeq = $("#floor option:selected").val();
		
		if ($("#floor option:selected").text() == "--선택--") {
			$.ajax({
				url : 'monthSelectFloor.do',
				data : {month:month, placeSeq:placeSeq, detailSeq:detailSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].floorName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		} else {
			$.ajax({
				url : 'monthSelectGender.do',
				data : {month:month, placeSeq:placeSeq, detailSeq:detailSeq, floorSeq:floorSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							$("#gender").append("<option value =" + data[i].genderNum + ">" + data[i].genderName + "</option>")
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].genderName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		}
	});
});

// selcetBox All
$(function() {
	$('#gender').change(function(){
		var month = $("#month option:selected").val();
		var placeSeq = $("#place option:selected").val();
		var detailSeq = $("#detail option:selected").val();
		var floorSeq = $("#floor option:selected").val();
		var genderNum = $("#gender option:selected").val();
		
		if ($("#gender option:selected").text() == "--선택--") {
			$.ajax({
				url : 'monthSelectGender.do',
				data : {month:month, placeSeq:placeSeq, detailSeq:detailSeq, floorSeq:floorSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].genderName + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		} else {
			$.ajax({
				url : 'monthSelectAll.do',
				data : {month:month, placeSeq:placeSeq, detailSeq:detailSeq, floorSeq:floorSeq, genderNum:genderNum},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length >= 1) {
						var max;
						var contents = "";
						
						$("#graphDiv > *").remove();
						
						contents +=	"<ul class='y-axis'>";
						contents +=	"<li><span>100%</span></li>";
						contents +=	"<li><span>80%</span></li>";
						contents +=	"<li><span>60%</span></li>";
						contents +=	"<li><span>40%</span></li>";
						contents +=	"<li><span>20%</span></li>";
						contents +=	"<li><span>0%</span></li>";
						contents +=	"</ul>";
						
						$("#graphDiv").append(contents);
							
						for (i = 0; i < data.length; i++) {
							max = data[i].max;
						}
						for (i = 0; i < data.length -1; i++) {
							
							var percent = Math.floor(data[i].statisticsUseNum / max * 100);
							contents = "";
							
							contents += "<div class='bar'>";
							contents += "<div class='title'><strong>" + data[i].raspberrypiIp + "</strong></div>";
							contents += "<div class='value tooltips' data-original-title='" + data[i].statisticsUseNum + "회' data-toggle='tooltip' data-placement='top' style='height:" + percent + "%'></div>";
							contents += "<div class='tooltip fade top in' role='tooltip' style='top: -50px; left: 5px; display: block;'><div class='tooltip-arrow'></div><div class='tooltip-inner'>"+ data[i].statisticsUseNum + "회</div></div>";
							contents += "</div>";
							
							$("#graphDiv").append(contents);
						}
					} else {
						$("#graphDiv > *").remove();
					}
			    }
			});	   
		}
	});
});