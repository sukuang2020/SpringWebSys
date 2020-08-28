$(document).ready(function() {
	var table = $('#empTable').DataTable({
		"sAjaxSource" : "/employee/api",
		"sAjaxDataProp" : "",
	    "ordering": true,
		"order" : [ [ 0, "asc" ] ],
		'select': {
			      'style': 'multi'
		},
		"aoColumns" : [ {
			data : "id"
		}, {
			data : "name"
		} ]
	});


	$('#delBtn').on('click', function(){


	});

	$('#editBtn').on('click', function(){


        var form = $('#editForm');
        form.attr('action', '/employee/001_001_002/edit');
        form.submit();
	});

	$('#addBtn').on('click', function(){

        var form = $('#editForm');
        form.attr('action', '/employee/new');
        form.submit();
	});

});



//$(document).ready(function() {
//	var table = $('#empTable').DataTable({
//		"sAjaxSource" : "/employee/api",
//		"sAjaxDataProp" : "",
//	    "ordering": true,
//		"order" : [ [ 0, "asc" ] ],
//		'select': {
//			      'style': 'multi'
//		},
//		"aoColumns" : [ {
//			 data : "id",
//	         'targets': 0,
//	         'checkboxes': {
//	            'selectRow': true
//	         }
//		}, {
//			data : "id"
//		}, {
//			data : "name"
//		}, {
//			className: 'f32', // used by world-flags-sprite library
//            data: 'office',
//            render: function(data, type) {
//                if (type === 'display') {
//                    var country = '';
//
//                    switch (data) {
//                        case 'SA':
//                            country = 'cn';
//                            break;
//                        case 'SB':
//                            country = 'jp';
//                            break;
//                        case 'SC':
//                            country = '_England';
//                            break;
//                        case 'SD':
//                        case 'San Francisco':
//                            country = 'us';
//                            break;
//                        case 'SE':
//                            country = 'au';
//                            break;
//                    }
//                    return '<span class="flag ' + country + '"></span> ' + data;
//                }
//                return data;
//            }
//		}, {
//			data: 'extn',
//            render: function(data, type, row, meta) {
//                return type === 'display' ?
//                    '<progress value="' + data + '" max="9999"></progress>' :
//                    data;
//            }
//		}, {
//			data : "jobrole"
//		}, {
//			data: "salary",
//            render: $.fn.dataTable.render.number( ',', '.', 2, '$' )
//		}, {
//			data: "startdate"
//		}, {
//			data: "enddate"
//		}, {
//			data: "email"
//		}  ]
//	});
//
//
//	$('#delBtn').on('click', function(){
//
//		var selRows = table.column(0).checkboxes.selected();
//		var data = table.rows().data();
//		var ids = "";
//
//		$.each(selRows, function(index, rowId){
//			ids += rowId + ",";
//		});
//
//        var form = $('#delForm');
//        form.attr('action', '/employee/' + ids);
//        form.submit();
//
//
////	    $.ajax({
////	        type : "DELETE",
////	        url : "/employee/del/" + ids,
////	        success: function (result) {
////	        	console.log(result);
////	        },
////	        error: function (e) {
////	            console.log(e);
////	        }
////	   })
//
//	});
//
//	$('#editBtn').on('click', function(){
//
//		var selRows = table.column(0).checkboxes.selected();
//		var data = table.rows().data();
//		var id = "";
//
//		$.each(selRows, function(index, rowId){
//			id += rowId;
//		});
//
//        var form = $('#editForm');
//        form.attr('action', '/employee/' + id + '/edit');
//        form.submit();
//	});
//
//	$('#addBtn').on('click', function(){
//
//        var form = $('#editForm');
//        form.attr('action', '/employee/new');
//        form.submit();
//	});
//
//});
//
