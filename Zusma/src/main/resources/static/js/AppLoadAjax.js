function getXmlHttp(){
	var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		//alert('chrome');
		xmlhttp=new XMLHttpRequest();
    }else{// code for IE6, IE5
		//alert('default');
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;
}

function getAjaxResponseWithoutInput(method,url){
	var xmlhttp = openAjax(method,url);
	alert(xmlhttp);
	var response = xmlhttp.responseText;
	alert(response);
	return response;
}

function getAjaxResponseWithInput(method,url,input){
	var xmlhttp = openAjax(method,url);
	return xmlhttp.responseText;
}

function openAjax(method,url){
	openAjaxWithCredentials(method,url,true,'','');
}

function openAjaxSynchronously(method,url){
	openAjaxWithCredentials(method,url,false,'','');
}

function openAjaxWithCredentials(method,url,async,username,password){
	var xmlhttp = getXmlHttp();
    xmlhttp.onreadystatechange=function(){
		alert(xmlhttp.readyState);
		alert(xmlhttp.status);
		if (xmlhttp.readyState==4 && xmlhttp.status==200){
			var response =xmlhttp.responseText;
			alert("response "+response);
		}
    }
    if(username != ''){
    	xmlhttp.open(method,url,async,username,password);
	}else{
		xmlhttp.open(method,url,async);
	}

	alert('sending');
	try{
		   xmlhttp.send();
	}catch(err){
		alert(err);
	}
 
    alert('ajax call over');
    return xmlhttp;
}

function doAjaxPost(url){
	$.ajax({
		type: "POST",
		url: url,
		success: function(){
			
		}
	});
}

function processOutput(output,ids){
	 var arrayLength = ids.length;
	 var ele;
	 var tagId;
	 var arr;
	 console.log('arrayLength '+arrayLength);
	/* var isValid = checkForValidSession(output);
	 if(!isValid){
		 return;
	 }*/
	for(var i = 0; i<arrayLength ; i++){
		tagId = '#'+ids[i];
		console.log('tagId '+tagId);
		if(tagId.indexOf("dropdown_")!=-1){
			arr = tagId.split("_");
			console.log('dropdowncalled ..'+tagId);
			var option = tagId+" option";
			var defaultValue = '';
			console.log('option '+option);
			$(option).each(function() {
				defaultValue = $(this).val();
				console.log('each loop '+defaultValue);
			    return false;
			});
			console.log('defaultValue '+defaultValue);
			option = "<option >"+ defaultValue+" </option>";
			$(tagId).html(option);
			$.each(
					output,
					function(index,value){
						console.log('value is ...'+value+" ,index ..."+index+' array '+arr[1]);
						if(arr[1] == index){
							console.log('value :'+value+" ,index :"+index+" ,length :"+value.length);
							var c = 0;
							while(c<value.length){
								$(tagId).append(
							              $('<option></option>').val(value[c]).html(value[c])
							    );
								c++;
							}
							
							return false;
						}
					}	
			);
				
		}else if(tagId.indexOf("dropdownmap_")!=-1){
			arr = tagId.split("_");
			console.log('dropdowncalled ..'+tagId);
			var option = tagId+" option";
			var defaultValue = '';
			console.log('option '+option);
			$(option).each(function() {
				defaultValue = $(this).val();
				console.log('each loop '+defaultValue);
			    return false;
			});
			console.log('defaultValue '+defaultValue);
			option = "<option >"+ defaultValue+" </option>";
			$(tagId).html(option);
			$.each(
					output,
					function(index,value){
						console.log("Index - "+index+' Array - '+arr[1]);
						if(arr[1] == index){
							console.log("map match");
							$.each(
									value,
									function(key,keyvalue){
										console.log('key :'+key+" ,keyvalue :"+keyvalue);
										$(tagId).append(
									              $('<option></option>').val(key).html(keyvalue)
									    );
							});
							return false;
						}
					}	
			);
				
		}else if(tagId.indexOf("dropdownselect_")!=-1){
			arr = tagId.split("_");
			$.each(
					output,
					function(index,value){
						console.log('value is ..........................'+value+" ,index ..."+index+' array '+arr[1]);
						if(arr[1] == index){
							$(tagId).val(value).change();
							console.log('set teh value '+value);
							return false;
						}
					}	
			);
		
		}else if(tagId.indexOf("label_")!=-1){
			arr = tagId.split("_");
			$.each(
					output,
					function(index,value){
						console.log('value is ...'+value+" ,index ..."+index+' array '+arr[1]);
						if(arr[1] == index){
							$(tagId).text('');
							$(tagId).text(value);
							console.log('set teh value '+value);
							return false;
						}
					}	
			);
		}else if(tagId.indexOf("input_")!=-1 || tagId.indexOf("textarea_")!=-1){
			arr = tagId.split("_");
			$.each(
					output,
					function(index,value){
						console.log('value is ...'+value+" ,index ..."+index+' array '+arr[1]);
						if(arr[1] == index){
							console.log('tagId......... '+tagId+' set teh value '+value);
							$(tagId).val(value);
							return false;
						}
					}	
			);
		}else if(tagId.indexOf("alert_")!=-1){
			arr = tagId.split("_");
			console.log('checking alert '+arr);
			$.each(
					output,
					function(index,value){
						console.log('value is ...'+value+" ,index ..."+index+' array '+arr[1]);
						if(arr[1] == index){
							alert(value);
							console.log('set teh value '+value);
							return false;
						}
					}	
			);
		}else if(tagId.indexOf("dynamictable_")!=-1){
			arr = tagId.split("_");
			console.log('checking dynamictable');
			var noofsupportcontacts;
			var r = new Array(), p = -1;
			var eachtablerecord;
			var eachtablerecordcolumns;
			$.each(
					output,
					function(index,value){
						console.log('value is ...'+value+" ,index ..."+index+' array '+arr[1]);
						if(arr[1] == index){
							console.log('table rows'+output[index]);
							var tableRows = output[index];
							if(tableRows!=null){
								noofsupportcontacts = tableRows.length;
								for(var ii = 0; ii<noofsupportcontacts ; ii++){
									eachtablerecord = tableRows[ii];
									eachtablerecordcolumns = eachtablerecord.length;
									
									for(var jj = 0; jj<eachtablerecordcolumns ; jj++){
										r[++p] ='<td><input type="text" value = "'+eachtablerecord[jj]+'" > </td>';
									}
									r[p] = '</tr>'+r[p]+'</tr>';
									console.log(r);
								}
							}
							$(tagId).html(r.join(''));
							return false;
						}
					}	
			);
		}
	}
}
/**
 * Finalized ajax calls
 * 1.doAjaxCallWithoutInputAndWithOutput
 * 2.doAjaxCallWithoutInputAndWithoutOutput
 * 3.doAjaxCallwithInputAndWithOutput
 * 4.doAjaxCallwithInputAndWithoutOutput
 */
function doAjaxCallWithoutInputAndWithOutput(resturl,method,id){
	alert("called doAjaxCallWithoutInputAndWithOutput");
	$.ajax({
		type: method,
		url: resturl,
		contentType: "application/json;charset=utf-8",
        dataType: "json",
		success: function(data){
			
		},
        error: function(e){
        	console.log(e.responseText);
        }
	}).then(function(data){
		console.log(data);
		processOutput(data,id);
		
		/* var ele = document.getElementById(id);
		 ele.setAttribute("ajaxResponse", data);
		 response = JSON.parse(data);
		 console.log(response);
		 console.log(data);*/
	});
}

function doAjaxCallWithoutInputAndWithoutOutput(resturl,method){
	$.ajax({
		type: method,
		url: resturl,
		success: function(data){
			alert('success');
		//	response = JSON.parse(data);
		},
        error: function(e){
        	
        	alert('Error: ' + e.responseText);
        }
	}).then(function(data){
		 /*var ele = document.getElementById(id);
		 ele.setAttribute("ajaxResponse", data);
		 alert(data);*/
	});
}

function doAjaxCallwithInputAndWithOutput(resturl,method,inputdata,ids){
	$.ajax({
		type: method,
		url: resturl,
		data: JSON.stringify( inputdata),
		contentType: 'application/json',
		dataType: 'json',
		success: function(data){
			
		},
        error: function(xhr, ajaxOptions, thrownError, request, error){
        	
        	console.log('xrs.status = ' + xhr.status + '\n' + 
        	            'thrown error = ' + thrownError + '\n' +
        	            'xhr.statusText = '  + xhr.statusText + '\n' +
        	            'request = ' + request + '\n' +
        	            'error = ' + error);
        }
	}).then(function(data){
		console.log("response "+data);
		processOutput(data,ids);
	});
}
function doAjaxCallwithInputAndWithoutOutput(resturl,method,inputdata){
	$.ajax({
		type: method,
		url: resturl,
		data: JSON.stringify( inputdata),
		contentType: 'application/json',
		dataType: 'json',
		success: function(data){
			
		},
		error: function(xhr, ajaxOptions, thrownError, request, error){
	        	
	        	console.log('xrs.status = ' + xhr.status + '\n' + 
	        	            'thrown error = ' + thrownError + '\n' +
	        	            'xhr.statusText = '  + xhr.statusText + '\n' +
	        	            'request = ' + request + '\n' +
	        	            'error = ' + error);
	        }
	});
}



function checkForValidSession(output){
	var isValid = true;
	$.each(
			output,
			function(index,value){
				console.log("value is "+value);
				if('fatal_invalidsession' == index){
					alert(value);
					doAjaxCallWithoutInputAndWithoutOutput('/ComplexTesting/logout','GET',null);
					window.location="http://localhost:8080/ComplexTesting/welcome";
					isValid = false;
				}
				return false;
			}	
	);
	return isValid;
}