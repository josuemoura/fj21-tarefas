<!-- Chamada da taglib [bloco - campoData] -->
<%@ attribute name="id" required="true"%>
<input type="text" id="${id}" name="${id}" />
<script type="text/javascript">
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy',changeMonth: true, changeYear: true, showWeek: true
	});
</script>