
	function memoView(num) {
		$.get("memoView/="+num, function(data) {
			alert(data.writer);
		});
	}

	function memoWrite(writer, contents) {
		$.ajax({
			url:"memoWrite",
			type:"POST",
			data:{
				writer:writer,
				contents:contents
			},
			success:function(data){
				var result="<table>";
				$(data).each(function() {
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.date+"</td>";
					result=result+"</tr>";
			});
				
				result = result+"</table>"
				$("#result").html(result);
			}
		});
		
	}
	function getList(curPage, find, search) {
		/* $.get("요청URL?name=value", function(data){});
		$.post("요청URL", {name=value}, function(data){});
		$.ajax({
			url:,
			datatype: get인지, post인지
			data:{},
			success : function(data){	
			}
		});
		$.("#result").load */
		
		
		$.ajax({
			url:"getMemoList/"+curPage+"/"+find+"/"+search,
			type: "GET",
			data:{
				curPage:curPage,
				find:find,
				search:search
			},
			success : function(data){
				/*alert(data);
				data = JSON.parse(data);
				alert(data[0].writer);*/
				var result="<table>";
				$(data).each(function() {
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.date+"</td>";
					result=result+"</tr>";
			});
				
				result = result+"</table>"
				$("#result").html(result);
			}
		});
	}