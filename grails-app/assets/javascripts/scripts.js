$(document).ready(function(){$('.carousel').carousel({interval:false});

/* affix the navbar after scroll below header */
$('#nav').affix({
      offset: {
        top: $('header').height()-$('#nav').height()
      }
});	

/* highlight the top nav as scrolling occurs */
$('body').scrollspy({ target: '#nav' })

/* smooth scrolling for scroll to top */
$('.scroll-top').click(function(){
  $('body,html').animate({scrollTop:0},1000);
})

/* smooth scrolling for nav sections */
$('#nav .navbar-nav li>a').click(function(){
  var link = $(this).attr('href');
  var posi = $(link).offset().top;
  $('body,html').animate({scrollTop:posi},700);
});


/* copy loaded thumbnails into carousel */
$('.panel .img-responsive').on('load', function() {
  
}).each(function(i) {
  if(this.complete) {
  	var item = $('<div class="item"></div>');
    var itemDiv = $(this).parent('a');
    var title = $(this).parent('a').attr("title");
    
    item.attr("title",title);
  	$(itemDiv.html()).appendTo(item);
  	item.appendTo('#modalCarousel .carousel-inner'); 
    if (i==0){ // set first item active
     item.addClass('active');
    }
  }
});

/* activate the carousel */
$('#modalCarousel').carousel({interval:false});

/* change modal title when slide changes */
$('#modalCarousel').on('slid.bs.carousel', function () {
  $('.modal-title').html($(this).find('.active').attr("title"));
})

/* when clicking a thumbnail */
$('.panel-thumbnail>a').click(function(e){
  
    e.preventDefault();
    var idx = $(this).parents('.panel').parent().index();
  	var id = parseInt(idx);
  	
  	$('#myModal').modal('show'); // show the modal
    $('#modalCarousel').carousel(id); // slide carousel to selected
  	return false;
});

//    load prices
    var pricetable = $('#pricestable');
pricetable.bootstrapTable({
    url: '/father-frost-booking/prices',
    onClickRow: function (row) {

    }
});

    jQuery('#datetimepicker').datetimepicker({
        datepicker:false,
        format:'H:i',
        inline:true,
        lang:'ru',
        style:'height:372px;'
    });

    var timepicker = $('#order-timepicker').timepicker({
        timeFormat: 'HH:mm'
    });

    timepicker.timepicker().on('changeTime.timepicker', function (e) {
        var dateAndPrice = getDateAndPrice();
        var text = 'Какой-то, блять, текст про заказ на ' + dateAndPrice.datetime +
            '. Стоимость заказа ' + dateAndPrice.price;


        $('#order-description').text(text);
    });

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