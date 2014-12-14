$(document).ready(function () {
    //скроем для начала инпут с таймпикером
    $('#datetimepicker').hide();

    //    load prices
    var pricetable = $('#pricestable');
    pricetable.bootstrapTable({
        url: '/price',
        onClickRow: function (row) {
            if (row.type == 'SINGLE_DAY' || row.type == 'INTERVAL') {
                checkTimes(row);
            } else {
                var text = 'Стоимость Вашего заказа составит ' + row.price + '. Для уточнения наиболее удобных Вам ' +
                    ' даты и времени с Вами свяжется наш менеджер в ближайшее время.';
                goToOrder(text);
            }
        }
    });

    function checkTimes(rowDay) {
        $.ajax('/order/times', {
            type: 'GET',
            data: {
                interval: rowDay.interval,
                type: rowDay.type
            },
            success: function (data, textStatus, jqXHR) {
                var times = data.times;
                console.log("times = " + times);

                createTimePicker(times);

                var height = Math.min(times.length * 25, pricetable.height() - 45)
                height = Math.min(height, 495 - 45);

                $('.xdsoft_time_box').height(height);
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
                    text = 'Дед Мороз придет к Вам в гости ' + dateAndPrice.datetime +
                    '. Стоимость заказа составит ' + dateAndPrice.price + " рублей.";
                    goToOrder(text);
                }
            }
        });
    }

    function goToOrder(text){
        $('#order-description').text(text);
        window.location = "#section5";
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
        var bookPeriod = pricetable.bootstrapTable('getSelections')[0].interval

        $.post('/order/save', {
            name: name,
            phone: phone,
            address: address,
            childrenAges: ages,
            comment: comment,
            bookDate: dateAndPrice.datetime,
            price: price,
            bookPeriod: bookPeriod
        });

        return false;
    });

    $('#callback-order').click(function(e) {
        e.stopImmediatePropagation();

        var name = callbackNameInput.val();
        var phone = callbackPhoneInput.val();
        var comment = callbackCommentInput.val();

        $.post('/order/callback', {
            name: name,
            phone: phone,
            comment: comment
        },function(data){

        })
    });

    var nameInput = $('#self-order-div input[name=name]');
    var phoneInput = $('#self-order-div input[name=phone]');
    var addressInput = $('#self-order-div input[name=address]');
    var agesInput = $('#self-order-div input[name=ages]');
    var commentInput = $('#self-order-div textarea[name=comment]');

    var callbackNameInput = $('#back-call-div input[name=name]');
    var callbackPhoneInput = $('#back-call-div input[name=phone]');
    var callbackCommentInput = $('#back-call-div textarea[name=comment]');


    function getDateAndPrice() {
        var timepicker = $('#datetimepicker');
        var time = timepicker.val();

        var datetime
        var selected = pricetable.bootstrapTable('getSelections');
        selected = selected[0];

        if (selected.type == 'SINGLE_DAY' || selected.type == 'INTERVAL') {
            var splitted = selected.interval.split(' ');
            var date = splitted[0] + ' ' + splitted[1];
            datetime = date + ' ' + time;
        }else{
            datetime = null;
        }

        var price = selected.price;

        return {
            datetime: datetime,
            price: price
        };
    }
});