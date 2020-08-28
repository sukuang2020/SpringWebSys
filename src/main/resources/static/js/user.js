//$.extend( true, $.fn.dataTable.defaults, {
//	'paging' : true,
//	'pageLength' : 10,
//	'lengthChange' : true,
//    "searching": true,
//    "ordering": true,
//	'info' : true,
//	'autoWidth' : false,
//	sPaginationType: "full_numbers",
//	'scrollX' : true,
//	'scrollY' : true,
//	"language" : {
//		"url":"//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
//	}
//} );
//
//$(document).ready(function() {
//	var table = $('#userTable').DataTable({
//		"sAjaxSource" : "/adminap/user/rest/all",
//		"sAjaxDataProp" : "",
//	    "ordering": true,
//		"order" : [ [ 0, "asc" ] ],
//		"aoColumns" : [ {
//			data : null,
//			render : function(data, type, row) {
//				return '<input type="checkbox">';
//			}
//		}, {
//			"mData" : "id"
//		}, {
//			"mData" : "name"
//		}, {
//			"mData" : "email"
//		} ],
//		"createdRow": function ( row, data, index ) {
//            if ( data[0] == "admin" ) {
//                $('td', row).eq(2).addClass('highlight');
//            }
//        }
//	})
//
//
//});
