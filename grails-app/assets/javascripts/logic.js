$(document).ready(function () {
    //скроем для начала инпут с таймпикером
    $('#datetimepicker').hide();

    //    load prices
    var pricetable = $('#pricestable');
    pricetable.bootstrapTable({
        url: '/price',
        onClickRow: function (row) {
            checkTimes(row);
            //showTimes();
        }
    });

    function checkTimes(rowDay) {
        $.ajax('/order/times', {
            type: 'GET',
            data: {
                interval: rowDay.interval
            },
            success: function (data, textStatus, jqXHR) {
                console.log("times = " + data.times);

                createTimePicker(data.times);

                $('.xdsoft_time_box').height(pricetable.height() - 45);
            },
            error: function (code) {
                debugger;
                console.log('error.code: ' + code)
            }
        })
    }

    function createTimePicker(allowTimes) {
        if (!$('#datetimepicker').is(":visible")) {
            $('#datetimepicker').show();
        }

        jQuery('#datetimepicker').datetimepicker({
            datepicker: false,
            format: 'H:i',
            inline: true,
            lang: 'ru',
            style: 'height:372px;',
            allowTimes: allowTimes,
            step: 30,
            onChangeDateTime: function (dp, $input) {
                var text;
                if ($input.val()) {
                    var dateAndPrice = getDateAndPrice();
                    text = 'Какой-то текст про заказ на ' + dateAndPrice.datetime +
                    '. Стоимость заказа ' + dateAndPrice.price;
                    window.location = "#section5";
                } else {
                    text = 'Чтобы оформить заказ самостоятельно, Вам нужно выбрать дату и время.';
                }
                $('#order-description').text(text);
            }
        });
    }


    var preorderMessage = function () {
        return {
            text: 'Чтобы оформить заказ самостоятельно, Вам нужно выбрать дату и время.',
            next: orderDescriptionMessage
        };
    }();

    var orderDescriptionMessage = function (dateTime, price) {
        return {
            text: 'Какой-то, блять, текст про заказ на ' + dateTime + '. Стоимость заказа ' + price,
            next: preorderMessage
        };
    }();

    i=0;

    $('#send-order').click(function (evt) {
        evt.stopPropagation();
        evt.preventDefault();
        evt.stopImmediatePropagation();

        var dateAndPrice = getDateAndPrice();
        var name = nameInput.val();
        var phone = phoneInput.val();
        var address = addressInput.val();
        var ages = agesInput.val();
        var comment = commentInput.val();
        var price = dateAndPrice.price.split(' ')[0];
        i++;
        console.log('i='+i);

        $.post('/order/save', {
            name: name,
            phone: phone,
            address: address,
            childrenAges: ages,
            comment: comment,
            bookDate: dateAndPrice.datetime,
            price: price
        })

        return false;
    });

    var nameInput = $('input[name=name]');
    var phoneInput = $('input[name=phone]');
    var addressInput = $('input[name=address]');
    var agesInput = $('input[name=ages]');
    var commentInput = $('textarea[name=comment]');

    function getDateAndPrice() {
        var timepicker = $('#datetimepicker');
        var time = timepicker.val();

        var selected = pricetable.bootstrapTable('getSelections');
        selected = selected[0];
        var splitted = selected.interval.split(' ');
        var date = splitted[0] + ' ' + splitted[1];
        var price = selected.price;

        return {
            datetime: date + ' ' + time,
            price: price
        };
    }
});