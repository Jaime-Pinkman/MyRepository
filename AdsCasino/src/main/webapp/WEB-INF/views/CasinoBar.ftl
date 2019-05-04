<#ftl encoding="Windows-1251"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Casino Bar</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="../../resources/css/styleAdsCat.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
            integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
            crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
            integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
            crossorigin="anonymous"></script>
    <script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>


</head>

<body onload="invise()">
<script>
    function invise() {
        //document.getElementById("inv").style.display="none";
        $.ajax({
            type: 'post',
            url: '/CasinoBar',
            /*data:{
            invise: invise
            }*/
        }).done(function (data) {
            //document.getElementById("inv").style.display="none";
            if (data == "admin") {
                document.getElementById("inv").style.display = "block"
            }
            else {
                document.getElementById("inv").style.display = "none";
            }

            /*let result = document.getElementById("id");
            if (data == "admin")
            result.innerHTML = data;
            document.getElementById("inv").style.display="none";*/
        }).fail(document.getElementById("inv").style.display = "none")
    }
</script>


<div class="wrapper">

    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header" class="active">
            <a href="/CasinoBar"><h3>Casino Bar</h3></a>
        </div>

        <ul class="list-unstyled components">
            <p>Title</p>
            <li>
                <a href='/ads'>Brands</a>
            </li>
            <li>
                <a href="#">Casino</a>
            </li>
            <li>
                <a href="#">Money</a>
            </li>
            <li>
                <a href="/catalog">Catalog</a>
            </li>
            <li>
                <a id="inv" href="/addAd">Add ad</a>
            </li>
        </ul>
    </nav>

    <!-- Page Content  -->
    <div id="content">

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>Menu</span>
                </button>
                <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fas fa-align-justify"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/CasinoBar" style="color: blue">to main</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #6d7fcc">rules</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" style="color: #6d7fcc">about</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="signIn" style="color: #6d7fcc">log in</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h2 style="color: #6d7fcc">Find what you need!</h2>

        <img class="d-block w-100" src="http://businesspskov.ru/pictures/170127115714.jpg" alt="First slide">

        <div class="line"></div>
        <a href='/ads'>
            <h2 style="color: #6d7fcc">Brands</h2>
        </a>
        <div class="row">
            <div class="col-sm">
                <h3>Be aware of new trends and make money on it.!</h3>
                <div class="row">
                    <div class="col-sm-2">
                    </div>
                    <div class="col-sm-6">
                        <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" src="../../resources/img/1.jpg" alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100"
                                         src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2V_NQ7w31x9_LBiSPLN2hymb_OtnqtVZPxvM7486EWX9WIks4bw"
                                         alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" src="../../resources/img/3.jpg" alt="Third slide">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <!--<li class="Mybutton"><a href="#" class="round green">Смотрu<span
                                class="round">И зарабатываu!</span></a></li>-->
                    </div>

                </div>
            </div>
            <div class="col-sm">
                <img src="http://www.sycaralocal.com/wp-content/uploads/2018/10/athletic-apparel-brands-logos-the-global-retail-sports-logot-satisfying-clothing-and-liveable-2.jpg">
            </div>
        </div>


        <div class="line"></div>

        <div class="row">
            <div class="col-sm-6">
                <h2 style="color: #6d7fcc">Casino</h2>
                <h3>Try your luck and score big!</h3>
                <div class="row">
                    <div class="col-sm-2"></div>

                    <div class="col-sm-6">

                        <ul>
                            <li>
                                <h4>Choose your favorite color</h4>
                            </li>
                            <li>
                                <h4>Put your points</h4>
                            </li>
                            <li>
                                <h4>Spin with all your might!</h4>
                            </li>
                            <li>
                                <h4>Cash out winnings ;)</h4>
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-4">
                        <li class="Mybutton"><a href="#" class="round green">Point<span
                                class="round">Play!</span></a></li>
                    </div>
                </div>

            </div>
            <div class="col-sm-4">
                <img class="d-block w-100" src="../../resources/img/4.jpg">
            </div>
            <div class="col-sm-2">
            </div>
        </div>

        <div class="line"></div>

        <h2 style="color: #6d7fcc">Keep us informed about your victories</h2>
        <h3>Refill your account and raise rates!</h3>
        <a href="#"><h4>Need more gold</h4></a>


        <div class="line"></div>

        <h2 style="color: #6d7fcc">The key to success</h2>
        <h3>The game is won by the one who knows its rules, so do not forget  <a>to familiarize</a></h3>

        <div class="line"></div>
        <#--<canvas id="canvas">
        </canvas>-->



        <footer class="footer-distributed">

            <div class="footer-left">

                <h3>Company<span>logo</span></h3>

                <p class="footer-links">
                    <a href="#">Home</a>
                    ·
                    <a href="#">Blog</a>
                    ·
                    <a href="#">Pricing</a>
                    ·
                    <a href="#">About</a>
                    ·
                    <a href="#">Faq</a>
                    ·
                    <a href="#">Contact</a>
                </p>

                <p class="footer-company-name">Company Name &copy; 2007</p>
            </div>

            <div class="footer-center">

                <div>
                    <i class="fa fa-map-marker"></i>
                    <p><span>45 Quay Street</span> Ufa, Bashkortostan</p>
                </div>

                <div>
                    <i class="fa fa-phone"></i>
                    <p>+7 999 6233127</p>
                </div>

                <div>
                    <i class="fa fa-envelope"></i>
                    <p><a href="mailto:support@company.com">marathon.our@gmail.com</a></p>
                </div>

            </div>

            <div class="footer-right">

                <p class="footer-company-about">
                    <span>About the company</span>
                    This is my company. my company is amazing
                </p>

                <div class="footer-icons">

                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-linkedin"></i></a>
                    <a href="#"><i class="fa fa-github"></i></a>

                </div>

            </div>

        </footer>

    </div>



    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
            integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
            crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
            integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
            crossorigin="anonymous"></script>
    <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#sidebarCollapse').on('click', function () {
                $('#sidebar, #content').toggleClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
    </script>
</body>
</html>