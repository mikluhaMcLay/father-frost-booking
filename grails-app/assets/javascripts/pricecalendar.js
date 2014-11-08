$(document).ready(function () {
    $.ajax({
        url: '/father-frost-booking/prices',
        type: 'GET',
        dataType: 'json',
        success: function (result) {
            console.log('result = ' + result);
            initScheduler(result);
        },
        error: function (xhr, status, error) {
            debugger;
            console.log('error: ' + error);
        }
    });
});

var initScheduler = function (data) {
    scheduler.config.readonly = true;
    scheduler.config.xml_date="%Y-%m-%d %H:%i";
    scheduler.config.first_hour = 10
    scheduler.xy.scale_height = 20; //sets the width of the Y-Axis  ;
    scheduler.date.week_start = function (date) {
        return date;
    };
    scheduler.attachEvent('onClick', function (id, e) {
        console.log('clicked event: id = ' + id + ' native event = ' + e);
    });
    scheduler.init('scheduler_here', new Date(2014, 11, 26), "week");
    scheduler.parse(data, 'json');
}