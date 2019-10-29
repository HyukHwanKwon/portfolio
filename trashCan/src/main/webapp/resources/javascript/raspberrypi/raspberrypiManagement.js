/**
 * raspberrypiManagement.js
 */

// selcet Box detail 제어 
$(function() {
	$('#place').change( function(){
		$("#detail").find('option').remove();
		$("#detail").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#floor").find('option').remove();
		$("#floor").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#raspberrypiManagementTable *").remove();
		$(".content-panel").css("display","none");
		var fkPlaceSeq = $("#place option:selected").val();
		
		if ($("#place option:selected").text() == "--선택--") {
			$("#raspberrypiManagementTable *").remove();
		} else {
			$.ajax({
				url : 'managementPiPlace.do',
				data : {fkPlaceSeq:fkPlaceSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						$(".content-panel").css("display","");
						
						var menu = "";
						
						menu += "<thead>";
						menu += "<tr>";
						menu += "<td><strong>라즈베리파이IP</strong></td>";
						menu += "<td><strong>장소</strong></td>";
						menu += "<td><strong>디테일</strong></td>";
						menu += "<td><strong>층</strong></td>";
						menu += "<td><strong>남/여</strong></td>";
						menu += "<td><strong>상태 값</strong></td>";
						menu += "<td><strong>0 = 사용x<br>1 = 사용o</strong></td>";
						menu += "</tr>";
						menu += "</thead>";
						menu += "<tbody>";
						
						$("#raspberrypiManagementTable").append(menu);
						
						for (i = 0; i < data.length; i++) {
							var contents ="";
							
							contents += "<tr>";
							contents += "<td>" + data[i].raspberrypiIp + "</td>";
							contents += "<td>" + data[i].placeName + "</td>";
							contents += "<td>" + data[i].detailName + "</td>";
							contents += "<td>" + data[i].floorName + "</td>";
							contents += "<td>" + data[i].genderName + "</td>";
							contents += "<td>" + data[i].raspberrypiStatus + "</td>";
							contents += "<td><a href='infomation.do?ip=" + data[i].raspberrypiIp + "'>변경</a></td>";
							contents += "</tr>";
							$("#raspberrypiManagementTable").append(contents);
						}
						contents = "";
						contents += "</tbody>";
						$("#raspberrypiManagementTable").append(contents);
					}
				}
			});
			
			$.ajax({
				url : 'managementDetail.do',
				data : {fkPlaceSeq:fkPlaceSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						for (i = 0; i < data.length; i++) {
							$("#detail").append("<option value =" + data[i].detailSeq + ">" + data[i].detailName + "</option>")
						}
					} 
				}
			});
		}
	});
});

// selcet Box floor 제어
$(function() {
	$('#detail').change( function(){
		$("#floor").find('option').remove();
		$("#floor").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#raspberrypiManagementTable *").remove();
		
		var fkPlaceSeq = $("#place option:selected").val();
		var fkDetailSeq = $("#detail option:selected").val();
		
		if ($("#detail option:selected").text() == "--선택--") {
			$.ajax({
				url : 'managementPiPlace.do',
				data : {fkPlaceSeq:fkPlaceSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						
						$(".content-panel").css("display","");
						
						var menu = "";
						
						menu += "<thead>";
						menu += "<tr>";
						menu += "<td><strong>라즈베리파이IP</strong></td>";
						menu += "<td><strong>장소</strong></td>";
						menu += "<td><strong>디테일</strong></td>";
						menu += "<td><strong>층</strong></td>";
						menu += "<td><strong>남/여</strong></td>";
						menu += "<td><strong>상태 값</strong></td>";
						menu += "<td><strong>0 = 사용x<br>1 = 사용o</strong></td>";
						menu += "</tr>";
						menu += "</thead>";
						menu += "<tbody>";
						
						$("#raspberrypiManagementTable").append(menu);
						
						for (i = 0; i < data.length; i++) {
							var contents ="";
							
							contents += "<tr>";
							contents += "<td>" + data[i].raspberrypiIp + "</td>";
							contents += "<td>" + data[i].placeName + "</td>";
							contents += "<td>" + data[i].detailName + "</td>";
							contents += "<td>" + data[i].floorName + "</td>";
							contents += "<td>" + data[i].genderName + "</td>";
							contents += "<td>" + data[i].raspberrypiStatus + "</td>";
							contents += "<td><a href='infomation.do?ip=" + data[i].raspberrypiIp + "'>변경</a></td>";
							contents += "</tr>";
							$("#raspberrypiManagementTable").append(contents);
						}
						contents = "";
						contents += "</tbody>";
						$("#raspberrypiManagementTable").append(contents);
					} 
				}
			});
		} else {
			$.ajax({
				url : 'managementPiDetail.do',
				data : {fkPlaceSeq:fkPlaceSeq, fkDetailSeq:fkDetailSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						
						$(".content-panel").css("display","");
						
						var menu = "";
						
						menu += "<thead>";
						menu += "<tr>";
						menu += "<td><strong>라즈베리파이IP</strong></td>";
						menu += "<td><strong>장소</strong></td>";
						menu += "<td><strong>디테일</strong></td>";
						menu += "<td><strong>층</strong></td>";
						menu += "<td><strong>남/여</strong></td>";
						menu += "<td><strong>상태 값</strong></td>";
						menu += "<td><strong>0 = 사용x<br>1 = 사용o</strong></td>";
						menu += "</tr>";
						menu += "</thead>";
						menu += "<tbody>";
						
						$("#raspberrypiManagementTable").append(menu);
						
						for (i = 0; i < data.length; i++) {
							var contents ="";
							
							contents += "<tr>";
							contents += "<td>" + data[i].raspberrypiIp + "</td>";
							contents += "<td>" + data[i].placeName + "</td>";
							contents += "<td>" + data[i].detailName + "</td>";
							contents += "<td>" + data[i].floorName + "</td>";
							contents += "<td>" + data[i].genderName + "</td>";
							contents += "<td>" + data[i].raspberrypiStatus + "</td>";
							contents += "<td><a href='infomation.do?ip=" + data[i].raspberrypiIp + "'>변경</a></td>";
							contents += "</tr>";
							$("#raspberrypiManagementTable").append(contents);
						}
						contents = "";
						contents += "</tbody>";
						$("#raspberrypiManagementTable").append(contents);
					}
				}
			});
			
			$.ajax({
				url : 'managementFloor.do',
				data : {fkDetailSeq:fkDetailSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						for (i = 0; i < data.length; i++) {
							$("#floor").append("<option value =" + data[i].floorSeq + ">" + data[i].floorName + "</option>")
						}
					}
			   	}
			});
		}
	});
});

// selcet Box gender 제어 
$(function() {
	$('#floor').change( function(){
		$("#gender").find('option').remove();
		$("#gender").append("<option value=" + "dump" + ">" + "--선택--" + "</option>");
		$("#raspberrypiManagementTable *").remove();
		
		var fkDetailSeq = $("#detail option:selected").val();
		var fkPlaceSeq = $("#place option:selected").val();
		var fkFloorSeq = $("#floor option:selected").val();
		
		if ($("#floor option:selected").text() == "--선택--") {
			$.ajax({
				url : 'managementPiDetail.do',
				data : {fkPlaceSeq:fkPlaceSeq, fkDetailSeq:fkDetailSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						
						$(".content-panel").css("display","");
						
						var menu = "";
						
						menu += "<thead>";
						menu += "<tr>";
						menu += "<td><strong>라즈베리파이IP</strong></td>";
						menu += "<td><strong>장소</strong></td>";
						menu += "<td><strong>디테일</strong></td>";
						menu += "<td><strong>층</strong></td>";
						menu += "<td><strong>남/여</strong></td>";
						menu += "<td><strong>상태 값</strong></td>";
						menu += "<td><strong>0 = 사용x<br>1 = 사용o</strong></td>";
						menu += "</tr>";
						menu += "</thead>";
						menu += "<tbody>";
						
						$("#raspberrypiManagementTable").append(menu);
						
						for (i = 0; i < data.length; i++) {
							var contents ="";
							
							contents += "<tr>";
							contents += "<td>" + data[i].raspberrypiIp + "</td>";
							contents += "<td>" + data[i].placeName + "</td>";
							contents += "<td>" + data[i].detailName + "</td>";
							contents += "<td>" + data[i].floorName + "</td>";
							contents += "<td>" + data[i].genderName + "</td>";
							contents += "<td>" + data[i].raspberrypiStatus + "</td>";
							contents += "<td><a href='infomation.do?ip=" + data[i].raspberrypiIp + "'>변경</a></td>";
							contents += "</tr>";
							$("#raspberrypiManagementTable").append(contents);
						}
						contents = "";
						contents += "</tbody>";
						$("#raspberrypiManagementTable").append(contents);
					}
			   	}
			});
		} else {
			$.ajax({
				url : 'managementPiFloor.do',
				data : {fkPlaceSeq:fkPlaceSeq, fkDetailSeq:fkDetailSeq, fkFloorSeq:fkFloorSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						
						$(".content-panel").css("display","");
						
						var menu = "";
						
						menu += "<thead>";
						menu += "<tr>";
						menu += "<td><strong>라즈베리파이IP</strong></td>";
						menu += "<td><strong>장소</strong></td>";
						menu += "<td><strong>디테일</strong></td>";
						menu += "<td><strong>층</strong></td>";
						menu += "<td><strong>남/여</strong></td>";
						menu += "<td><strong>상태 값</strong></td>";
						menu += "<td><strong>0 = 사용x<br>1 = 사용o</strong></td>";
						menu += "</tr>";
						menu += "</thead>";
						menu += "<tbody>";
						
						$("#raspberrypiManagementTable").append(menu);
						
						for (i = 0; i < data.length; i++) {
							var contents ="";
							
							contents += "<tr>";
							contents += "<td>" + data[i].raspberrypiIp + "</td>";
							contents += "<td>" + data[i].placeName + "</td>";
							contents += "<td>" + data[i].detailName + "</td>";
							contents += "<td>" + data[i].floorName + "</td>";
							contents += "<td>" + data[i].genderName + "</td>";
							contents += "<td>" + data[i].raspberrypiStatus + "</td>";
							contents += "<td><a href='infomation.do?ip=" + data[i].raspberrypiIp + "'>변경</a></td>";
							contents += "</tr>";
							$("#raspberrypiManagementTable").append(contents);
						}
						contents = "";
						contents += "</tbody>";
						$("#raspberrypiManagementTable").append(contents);
					}
			   	}
			});
			
			$.ajax({
				url : 'managementGender.do',
				data : {fkFloorSeq:fkFloorSeq, fkDetailSeq:fkDetailSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						for (i = 0; i < data.length; i++) {
							$("#gender").append("<option value =" + data[i].genderNum + ">" + data[i].genderName + "</option>")
						}
					}
			   	}
			});
		}
	});
});

//selcet Box All 제어 
$(function() {
	$('#gender').change( function(){
		var fkFloorSeq = $("#floor option:selected").val();
		var fkDetailSeq = $("#detail option:selected").val();
		var fkPlaceSeq = $("#place option:selected").val();
		var fkGenderNum = $("#gender option:selected").val();
		
		$("#raspberrypiManagementTable *").remove();
		
		if ($("#gender option:selected").text() == "--선택--") {
			$.ajax({
				url : 'managementPiFloor.do',
				data : {fkPlaceSeq:fkPlaceSeq, fkDetailSeq:fkDetailSeq, fkFloorSeq:fkFloorSeq},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						
						$(".content-panel").css("display","");
						
						var menu = "";
						
						menu += "<thead>";
						menu += "<tr>";
						menu += "<td><strong>라즈베리파이IP</strong></td>";
						menu += "<td><strong>장소</strong></td>";
						menu += "<td><strong>디테일</strong></td>";
						menu += "<td><strong>층</strong></td>";
						menu += "<td><strong>남/여</strong></td>";
						menu += "<td><strong>상태 값</strong></td>";
						menu += "<td><strong>0 = 사용x<br>1 = 사용o</strong></td>";
						menu += "</tr>";
						menu += "</thead>";
						menu += "<tbody>";
						
						$("#raspberrypiManagementTable").append(menu);
						
						for (i = 0; i < data.length; i++) {
							var contents ="";
							
							contents += "<tr>";
							contents += "<td>" + data[i].raspberrypiIp + "</td>";
							contents += "<td>" + data[i].placeName + "</td>";
							contents += "<td>" + data[i].detailName + "</td>";
							contents += "<td>" + data[i].floorName + "</td>";
							contents += "<td>" + data[i].genderName + "</td>";
							contents += "<td>" + data[i].raspberrypiStatus + "</td>";
							contents += "<td><a href='infomation.do?ip=" + data[i].raspberrypiIp + "'>변경</a></td>";
							contents += "</tr>";
							$("#raspberrypiManagementTable").append(contents);
						}
						contents = "";
						contents += "</tbody>";
						$("#raspberrypiManagementTable").append(contents);
					}	
			   	}
			});
		} else {
			$.ajax({
				url : 'managementPi.do',
				data : {fkFloorSeq:fkFloorSeq, fkDetailSeq:fkDetailSeq, fkPlaceSeq:fkPlaceSeq, fkGenderNum:fkGenderNum},
			    type : 'post',
			    dataType: 'json',
				success : function(data){
					if (data.length > 0) {
						
						$(".content-panel").css("display","");
						
						var menu = "";
						
						menu += "<thead>";
						menu += "<tr>";
						menu += "<td><strong>라즈베리파이IP</strong></td>";
						menu += "<td><strong>장소</strong></td>";
						menu += "<td><strong>디테일</strong></td>";
						menu += "<td><strong>층</strong></td>";
						menu += "<td><strong>남/여</strong></td>";
						menu += "<td><strong>상태 값</strong></td>";
						menu += "<td><strong>0 = 사용x<br>1 = 사용o</strong></td>";
						menu += "</tr>";
						menu += "</thead>";
						menu += "<tbody>";
						
						$("#raspberrypiManagementTable").append(menu);
						
						for (i = 0; i < data.length; i++) {
							var contents ="";
							
							contents += "<tr>";
							contents += "<td>" + data[i].raspberrypiIp + "</td>";
							contents += "<td>" + data[i].placeName + "</td>";
							contents += "<td>" + data[i].detailName + "</td>";
							contents += "<td>" + data[i].floorName + "</td>";
							contents += "<td>" + data[i].genderName + "</td>";
							contents += "<td>" + data[i].raspberrypiStatus + "</td>";
							contents += "<td><a href='infomation.do?ip=" + data[i].raspberrypiIp + "'>변경</a></td>";
							contents += "</tr>";
							$("#raspberrypiManagementTable").append(contents);
						}
						contents = "";
						contents += "</tbody>";
						$("#raspberrypiManagementTable").append(contents);
					}
			   	}
			});
		}
	});
});