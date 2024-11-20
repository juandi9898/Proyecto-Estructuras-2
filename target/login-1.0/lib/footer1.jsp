<script src="https://code.jquery.com/jquery-3.7.1.js"></script> <!-- jQuery, si lo necesitas -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>
<script src="https://cdn.datatables.net/2.1.8/js/dataTables.bootstrap5.js"></script>

<!-- Cambiando el idioma a Espa�ol e incializando Datatable-->
<script>
    $(document).ready(function() {
        $('#myTable').DataTable({
            "language": {
                "url": "https://cdn.datatables.net/plug-ins/2.1.8/i18n/es-ES.json",
                "paginate": {
                    "next": ">",
                    "previous": "<"
                }
            },
            "order": [[0, "desc"]] // Ordenar descendente en la primera columna
        });
    });
</script>







</body>
</html>