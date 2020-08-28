$(document).ready(function() {
	var table = $('#playerTable').DataTable({
		"sAjaxSource" : "/player/api",
		"sAjaxDataProp" : "",
	    "ordering": true,
		"order" : [ [ 0, "asc" ] ],
		'select': {
			      'style': 'multi'
		},
		"aoColumns" : [ {
			data : "id",
			render : function(data, type, row) {
				return '<input class="" type="checkbox" id="check1a" value="1">';
			}
		}, {
			data : "id"
		}, {
			data : "name"
		}, {
			data : "team"
		}, {
			data: 'age'
		}, {
			data : "position"
		}, {
			data : "id",
			render : function(data, type, row) {
				return '<a class="nav-link" href="/player/' + data + '/edit"><i class="fas fa-edit"></i>編集</a>';
			}
		}, {
			data : null,
			render : function(data, type, row) {
				return '<input type="checkbox" id="check1a" value="1">';
			}
		}, {
			data : "id",
			render : function(data, type, row) {
				return '<form action="/player/' + data + '" method="post"><input class="btn btn-danger" type="submit" value="削除" /></form>';
			}
		}  ]
	});



});



/**
 * 显示错误信息
 * @param result： 错误信息
 */
function showError(s) {
    alert(s);
}

/**
 * 处理 ajax 请求结果
 * @param result： ajax 返回的结果
 * @param fn： 成功的处理函数 ( 传入data: fn(result.data) )
 */
function handlerResult(result, fn) {
    // 成功执行操作，失败提示原因
    if (result.code == 0) {
        fn(result.data);
    }
    // 用户操作异常, 这里可以对 1 或 2 等错误码进行单独处理, 也可以 result.code > 0 来粗粒度的处理, 根据业务而定.
    else if (result.code == 1) {
        showError(result.message);
    }
    // 系统异常, 这里可以对 -1 或 -2 等错误码进行单独处理, 也可以 result.code > 0 来粗粒度的处理, 根据业务而定.
    else if (result.code == -1) {
        showError(result.message);
    }
    // 如果进行细粒度的状态码判断, 那么就应该重点注意这里没出现过的状态码. 这个判断仅建议在开发阶段保留用来发现未定义的状态码.
    else {
        showError("出现未定义的状态码:" + result.code);
    }
}

/**
 * 根据 id 删除商品
 */
function deleteGoods(id) {
    $.ajax({
        type: "GET",
        url: "/player/api/delete/SP100007",
        success: function(result){
            handlerResult(result, deleteDone);
        }
    });
}

function deleteDone(data) {
    alert(data);
}