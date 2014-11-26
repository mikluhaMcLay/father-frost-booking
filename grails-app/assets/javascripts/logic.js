$(document).ready(function(){
    var isTimesShown = false;

    var timeBox;    //хуйня с часами и минутами (часть timepicker)
    var timepicker; //весь DateTimePicker

    //    load prices
    var pricetable = $('#pricestable');
    pricetable.bootstrapTable({
        url: '/father-frost-booking/prices',
        onClickRow: function (row) {
            checkTimes(row);
            //showTimes();
        }
    });

    //function showTimes(){
    //    if (!isTimesShown) {
    //        timeBox.height(pricetable.height() - 45);
    //        timeBox.show();
    //        $('.xdsoft_prev, .xdsoft_next').show();
    //
    //        isTimesShown = true;
    //    }
    //}
    function checkTimes(rowDay){
        $.ajax('/father-frost-booking/order/times',{
            type: 'GET',
            data: {
                interval: rowDay.interval
            },
            success: function(data, textStatus, jqXHR){
                console.log("times = " + data.times);

                createTimePicker(data.times);

                $('.xdsoft_time_box').height( pricetable.height() - 45 );
            },
            error: function(code){
                debugger;
                console.log('error.code: ' + code)
            }
        })
    }

    function createTimePicker(allowTimes){
        jQuery('#datetimepicker').datetimepicker({
            datepicker:false,
            format:'H:i',
            inline:true,
            lang:'ru',
            style:'height:372px;',
            allowTimes: allowTimes
        });
    }

    //$('.xdsoft_prev, .xdsoft_next').hide();
    //$('.xdsoft_time_box').hide();
    //timeBox = $('.xdsoft_time_box');

    //timepicker.timepicker().on('changeTime.timepicker', function (e) {
    //    var dateAndPrice = getDateAndPrice();
    //    var text = 'Какой-то, блять, текст про заказ на ' + dateAndPrice.datetime +
    //        '. Стоимость заказа ' + dateAndPrice.price;
    //
    //
    //    $('#order-description').text(text);
    //});

    i=0;

    $('#send-order').click(function(){
        var dateAndPrice = getDateAndPrice();
        var name = nameInput.val();
        var phone = phoneInput.val();
        var address = addressInput.val();
        var ages = agesInput.val();
        var comment = commentInput.val();
        var price = dateAndPrice.price.split(' ')[0];
        i++;
        console.log(i);
        $.post('/father-frost-booking/order',{
            name: name,
            phone: phone,
            address: address,
            childrenAges: ages,
            comment: comment,
            bookDate: dateAndPrice.datetime,
            price: price
        })
    });

    var nameInput = $('input[name=name]');
    var phoneInput = $('input[name=phone]');
    var addressInput = $('input[name=address]');
    var agesInput = $('input[name=ages]');
    var commentInput = $('textarea[name=comment]');

    function getDateAndPrice(){
        var time = timepicker.val();

        var selected = pricetable.bootstrapTable('getSelections');
        selected = selected[0];
        var date = selected.interval.split(' ')[0];
        var price = selected.price;

        return {
            datetime: date + ' ' + time,
            price: price
        };
    }
});