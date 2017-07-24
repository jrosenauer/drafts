$(document).ready(function () {

    loadOrganizations();
    loadSightings();
    loadLocations();
    $('#create-sighting').click(function () {

        var locationList = $('#location-selector').val();
        var superList = $('#super-selector').val();

        $.ajax({
            type: 'POST',
            url: 'createSighting',
            data: JSON.stringify({
                sightingDate: $('#add-sighting-date').val(),
                locationID: locationList,
                superID: superList
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function (data, status) {
                $('#add-sighting-date').val(''),
                        loadSightings();
            }
        });

    });

    function loadSightings() {
        $.ajax({
            url: "sightings"
        }).success(function (data, status) {
            fillSightingTable(data, status);
        });
    }

    $('#edit-sighting-button').click(function (event) {
        $.ajax({
            type: 'PUT',
            url: 'sighting/' + $('#edit-sighting-id').val(),
            data: JSON.stringify({
                date: $('#edit-sighting-date').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadSightings();
        });
    });

    function fillSightingTable(sightingList, status) {
        clearSightingTable();
        var sightingTable = ('#sighting-rows');
        $.each(sightingList, function (index, sighting) {
            var sightingInfo = '<tr>';
            sightingInfo += '<td>' + sighting.sightingID + '</td>';
            sightingInfo += '<td>' + sighting.locationID + '</td>';
            sightingInfo += '<td>' + sighting.sightingID + '</td>';
            sightingInfo += '</tr>';
            sightingTable.append(sightingInfo);
        });
    }

    function clearSightingTable() {
        $('#sighting-rows').empty();
    }

    function deleteSighting(id) {
        var answer = confirm("Do you wish to delete?");
        if (answer === true) {
            $.ajax({
                type: 'DELETE',
                url: 'sighting/' + id
            }).success(function () {
                loadSightings();
            });
        }
    }
});

