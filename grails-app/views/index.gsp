<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>True frost — вызов деда мороза на дом</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
    <asset:stylesheet src="bootstrap.min.css"/>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="styles.css"/>
    <asset:stylesheet src="bootstrap-table.min.css"/>
    <asset:stylesheet src="jquery.datetimepicker.css"/>

    <asset:javascript src="application.js"/>
    <asset:javascript src="bootstrap-table.min.js"/>
    <asset:javascript src="jquery.datetimepicker.js"/>

</head>

<body>
<!-- Wrap all page content here -->
<div id="wrap">

    <header class="masthead">

        <!-- Fixed navbar -->
        <div class="navbar navbar-custom navbar-inverse navbar-static-top" id="nav">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>

                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav nav-justified">
                        <li><a href="#section1">Мы</a></li>
                        <li><a href="#section2">Программы</a></li>
                        %{--<li><a href="#section3">фотки</a></li>--}%
                        <li><a href="#section4">цены</a></li>
                        <li><a href="#section4">заказать</a></li>
                        <li><a href="#section6">контакты</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container -->
        </div><!--/.navbar -->

    <div class="container" style="position:inherit;height: 285px;width: 100%">
        <img src="${assetPath( src: 'DedMorozExists-white.png' )}" class="our-logo"
             style="max-width: 285px; max-height: 285px">
        <div class="col-sm-10 col-sm-offset-1">

        </div>

    </div>

        <div class="divider"></div>
        <div class="container">
            <div class="our-text col-sm-10 col-sm-offset-1" style="height: 100%;">
                <p class="lead text-center" style="text-shadow: 0 1px 2px rgba(0,0,0,0.6); font-size: 30px">
                    Закажите новогодний праздник для своего ребенка!
                </p>
                <p class="lead text-center" >
                    Привет, мы компания «Дед Мороз существует», и для нас это не просто название.
                </p>

                <p class="lead text-center">
                    Мы твердо убеждены, что новогодние чудеса случаются до тех пор, пока наши дети в них верят.
                </p>

                <p class="lead text-center" style="font-style: italic; line-weight:1.4">
                    А каким запомнит этот новый год ваш ребенок?
                </p>

            </div>


        </div>
    <!-- Carousel
    ================================================== -->
        %{--<div id="myCarousel" class="carousel slide">--}%
            %{--<!-- Indicators -->--}%
            %{--<ol class="carousel-indicators">--}%
                %{--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>--}%
                %{--<li data-target="#myCarousel" data-slide-to="1"></li>--}%
                %{--<li data-target="#myCarousel" data-slide-to="2"></li>--}%
            %{--</ol>--}%

            %{--<div class="carousel-inner">--}%
                %{--<div class="item active">--}%

                    %{--<div class="container vertical-center" style="height: 100%;">--}%
                        %{--<div class="our-text col-sm-10 col-sm-offset-1" style="height: 100%;">--}%
                            %{--<p class="lead text-center" style="font-weight: 800;font-size: 28px;">--}%
                                %{--Закажите новогодний праздник для своего ребенка!--}%
                            %{--</p>--}%

                            %{--<p class="lead text-center" >--}%
                                %{--Привет, мы компания «Дед Мороз существует», и для нас это не просто название.--}%
                            %{--</p>--}%

                            %{--<p class="lead text-center">--}%
                                %{--Мы твердо убеждены, что новогодние чудеса случаются до тех пор, пока наши дети в них верят.--}%
                            %{--</p>--}%

                            %{--<p class="lead text-center" style="font-style: italic;">--}%
                                %{--А каким запомнит этот новый год ваш ребенок?--}%
                            %{--</p>--}%

                        %{--</div>--}%

                        %{--<div class="carousel-caption">--}%
                            %{--<h2>Interior Design</h2>--}%

                            %{--<p></p>--}%
                        %{--</div>--}%
                    %{--</div>--}%

                %{--</div>--}%

                %{--<div class="item">--}%
                    %{--<img src="${assetPath( src: 'interior.jpg' )}">--}%

                    %{--<div class="container">--}%
                        %{--<div class="carousel-caption">--}%
                            %{--<iframe width="622" height="350"--}%
                                    %{--src="http://www.youtube.com/v/7zXn57WT4sQ" allowFullScreen="1"--}%
                                    %{--frameborder="0"></iframe>--}%

                            %{--<h2>Architectural Design</h2>--}%

                            %{--<p></p>--}%
                        %{--</div>--}%
                    %{--</div>--}%
                %{--</div>--}%

                %{--<div class="item">--}%
                    %{--<img src="${assetPath( src: 'renovation.jpg' )}">--}%

                    %{--<div class="container">--}%
                        %{--<div class="carousel-caption">--}%
                            %{--<h2>Renovations &amp; Adaptive Re-use</h2>--}%

                            %{--<p></p>--}%
                        %{--</div>--}%
                    %{--</div>--}%
                %{--</div>--}%
            %{--</div><!-- /.carousel-inner -->--}%
            %{--<div class="logo">--}%
            %{--</div>--}%
            %{--<!-- Controls -->--}%
            %{--<a class="left carousel-control" href="#myCarousel" data-slide="prev">--}%
                %{--<span class="glyphicon glyphicon-chevron-left"></span>--}%
            %{--</a>--}%
            %{--<a class="right carousel-control" href="#myCarousel" data-slide="next">--}%
                %{--<span class="glyphicon glyphicon-chevron-right"></span>--}%
            %{--</a>--}%
        %{--</div>--}%
        <!-- /.carousel -->

    </header>

    <div class="divider"></div>

    <!-- Begin page content -->
    <div class="divider" id="section1"></div>

    <div class="container">
        <div class="col-sm-10 col-sm-offset-1 our-text">
            <div class="page-header text-center">
                <h1>Почему мы?</h1>
            </div>

            <p style="font-weight: 500; font-size:24px;">А теперь давайте без лишней лирики - только факты:</p>
            <ul>
                <li>Большая команда актеров с опытом работы</li>
                <li>Новые качественные костюмы</li>
                <li>Проработанная программа</li>
                <li>Мы хотим стать самым крутым сервисом настроения в Москве, и нам действительно важно качество предоставляемых услуг</li>
            </ul>

            <hr>

            <div class="divider"></div>

        </div>
    </div>

    <div class="divider"></div>

    <section class="bg-1">
        <div class="col-sm-6 col-sm-offset-3 text-center"></div>
    </section>

    <div class="divider" id="section2"></div>

    <div class="row">
        <div class="col-sm-10 col-sm-offset-1 text-center our-text">
            <h1>Программы</h1>

            <hr>

            <p>
                Расскажем, какие у нас есть программы
            </p>

            <p>
                какой у нас индивидуальный подход к детям
            </p>

            <p>
                ну и прочая херня
            </p>

            <hr>

            <div class="divider"></div>

        </div><!--/col-->
    </div><!--/container-->

    <div class="divider"></div>

    <section class="bg-3">
        %{--<div class="col-sm-6 col-sm-offset-3 text-center"><h2--}%
                %{--style="padding:20px;background-color:rgba(5,5,5,.8)">Clients &amp; Partners</h2>--}%
        %{--</div>--}%
    </section>

    %{--<div class="divider" id="section3"></div>--}%

    %{--<div class="bg-4">--}%
        %{--<div class="container">--}%
            %{--<div class="row">--}%
                %{--<div class="col-sm-4 col-xs-6">--}%

                    %{--<div class="panel panel-default">--}%
                        %{--<div class="panel-thumbnail"><a href="#" title="Renovations"><img--}%
                                %{--src="//placehold.it/600x400/444/F8F8F8" class="img-responsive"></a></div>--}%

                        %{--<div class="panel-body">--}%
                            %{--<p>Renovations</p>--}%

                            %{--<p></p>--}%

                        %{--</div>--}%
                    %{--</div><!--/panel-->--}%
                %{--</div><!--/col-->--}%

                %{--<div class="col-sm-4 col-xs-6">--}%

                    %{--<div class="panel panel-default">--}%
                        %{--<div class="panel-thumbnail"><a href="#" title="Academic Institutions"><img--}%
                                %{--src="//placehold.it/600x400/454545/FFF" class="img-responsive"></a></div>--}%

                        %{--<div class="panel-body">--}%
                            %{--<p>Academic Institutions</p>--}%

                            %{--<p></p>--}%

                        %{--</div>--}%
                    %{--</div><!--/panel-->--}%
                %{--</div><!--/col-->--}%

                %{--<div class="col-sm-4 col-xs-6">--}%

                    %{--<div class="panel panel-default">--}%
                        %{--<div class="panel-thumbnail"><a href="#" title="Interiors"><img--}%
                                %{--src="//placehold.it/600x400/555/F2F2F2" class="img-responsive"></a></div>--}%

                        %{--<div class="panel-body">--}%
                            %{--<p>Interiors</p>--}%

                            %{--<p></p>--}%

                        %{--</div>--}%
                    %{--</div><!--/panel-->--}%

                %{--</div><!--/col-->--}%

                %{--<div class="col-sm-4 col-xs-6">--}%

                    %{--<div class="panel panel-default">--}%
                        %{--<div class="panel-thumbnail"><a href="#" title="New Construction"><img--}%
                                %{--src="//placehold.it/600x400/555/FFF" class="img-responsive"></a></div>--}%

                        %{--<div class="panel-body">--}%
                            %{--<p>New Construction</p>--}%

                            %{--<p></p>--}%

                        %{--</div>--}%
                    %{--</div><!--/panel-->--}%

                %{--</div><!--/col-->--}%

                %{--<div class="col-sm-4 col-xs-6">--}%

                    %{--<div class="panel panel-default">--}%
                        %{--<div class="panel-thumbnail"><a href="#" title="Site Planning"><img--}%
                                %{--src="//placehold.it/600x400/555/EEE" class="img-responsive"></a></div>--}%

                        %{--<div class="panel-body">--}%
                            %{--<p>Site Planning</p>--}%

                            %{--<p></p>--}%

                        %{--</div>--}%
                    %{--</div><!--/panel-->--}%

                %{--</div><!--/col-->--}%

                %{--<div class="col-sm-4 col-xs-6">--}%

                    %{--<div class="panel panel-default">--}%
                        %{--<div class="panel-thumbnail"><a href="#" title="Churches"><img--}%
                                %{--src="//placehold.it/600x400/666/F4F4F4" class="img-responsive"></a></div>--}%

                        %{--<div class="panel-body">--}%
                            %{--<p>Churches</p>--}%

                            %{--<p></p>--}%

                        %{--</div>--}%
                    %{--</div><!--/panel-->--}%

                %{--</div><!--/col-->--}%

            %{--</div><!--/row-->--}%
        %{--</div><!--/container-->--}%
    %{--</div>--}%

    <div class="divider" id="section4"></div>

    <div class="row">
        <div class="col-md-8 col-md-offset-2 text-center our-text">
            <h1>Цены</h1>

            <div class="row text-center">
                <p class="col-md-6 col-md-offset-1">
                    Чтобы сделать заказ, выберите подходящие дату и время
                </p>
            </div>
            %{--<div class="col-sm-4 col-xs-6">--}%
            <div class="row price-picker">
                <div class="col-xs-10 col-md-8 col-lg-8 col-md-offset-1">
                    <table id="pricestable"
                           data-url="/prices"
                           data-click-to-select="true"
                           data-select-item-name="radioName"
                           data-show-header="false">
                        <thead>
                        <tr>
                            <th style="max-width: 15px;" data-field="state" data-align="center" data-radio="true"></th>
                            <th data-field="interval" data-align="center">Время</th>
                            <th data-field="price" data-align="center">Цена</th>
                        </tr>
                        </thead>
                    </table>
                </div>
                %{--<input id="order-timepicker">--}%
                <div class="col-xs-1 time">
                    <input id="datetimepicker" type="text">
                </div>
            </div>



            %{--</div>--}%
        </div>
    </div>

    <div class="divider" id="section5"></div>

    <div class="row">

        <hr>

        <div id="self-order-div"><div class="col-sm-9 col-sm-offset-1 our-text">

            <div class="row form-group text-center">
                <div class="col-md-12">
                    <h1>Отправить заказ</h1>
                </div>
            </div>

            <div class="col-md-offset-4">
                <div class="order-input row">
                    <p class="col-md-6" id="order-description"></p>
                </div>

                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <input type="text" class="form-control" id="firstName" name="name"
                               placeholder="Имя и фамилия" required="required" data-bv-notempty="true">
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <input type="tel" required="" class="form-control" name="phone" placeholder="Телефон">
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <input type="text" required="" class="form-control" name="address" placeholder="Адрес">
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <input type="text" class="form-control" name="ages"
                               placeholder="Возраст детей">
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <textarea class="form-control" name="comment" placeholder="Комментарий"></textarea>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-md-10 col-md-offset-3">
                        <button id="send-order" class="btn btn-default pull-left">Отправить заказ</button>
                    </div>
                </div>
            </div>

        </div></div>

    </div><!--/row-->

%{--раздел с обратным звонком--}%
    <div class="divider" id="section6"></div>

    <div class="row">

        <hr>

        <div id="back-call-div"><div class="col-sm-9 col-sm-offset-1 our-text">

            <div class="row form-group text-center">
                <div class="col-md-12">
                    <h1>Обратный звонок</h1>
                </div>
            </div>

            <div class="col-md-offset-4">
                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <input type="text" class="form-control" id="firstName1" name="name"
                               placeholder="Ваши имя и фамилия">
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <input type="tel" required="" class="form-control" name="phone" placeholder="Телефон">
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-xs-6 order-input">
                        <textarea class="form-control" name="comment" placeholder="Комментарий"></textarea>
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-md-10 col-md-offset-3">
                        <button id="send-order1" class="btn btn-default pull-left">Обратный звонок</button>
                    </div>
                </div>
            </div>

        </div>
        </div>
    </div>

</div><!--/wrap-->



<div id="footer">
    <div class="container">
        <p class="text-muted">Copyright ©2014 True frost</p>
    </div>
</div>

<ul class="nav pull-right scroll-top">
    <li><a href="#" title="Scroll to top"><i class="glyphicon glyphicon-chevron-up"></i></a></li>
</ul>

<div class="modal" id="order-result" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">×</button>

                <h3 class="modal-title"></h3>
            </div>

            <div class="modal-body">
            </div>

            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="myModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">×</button>

                <h3 class="modal-title"></h3>
            </div>

            <div class="modal-body">
                <div id="modalCarousel" class="carousel">

                    <div class="carousel-inner">

                    </div>

                    <a class="carousel-control left" href="#modaCarousel" data-slide="prev"><i
                            class="glyphicon glyphicon-chevron-left"></i></a>
                    <a class="carousel-control right" href="#modalCarousel" data-slide="next"><i
                            class="glyphicon glyphicon-chevron-right"></i></a>

                </div>
            </div>

            <div class="modal-footer">
                <button class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<!-- script references -->

<asset:javascript src="scripts.js"/>
<asset:javascript src="logic.js"/>
</body>
</html>