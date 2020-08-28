$.extend( true, $.fn.dataTable.defaults, {
	'paging' : true,
	'pageLength' : 10,
	'lengthChange' : true,
    "searching": false,
    "ordering": false,
	'info' : true,
	'autoWidth' : false,
	sPaginationType: "full_numbers",
	'scrollX' : true,
	'scrollY' : true,
	"language" : {
		"url":"//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
	}
} );
