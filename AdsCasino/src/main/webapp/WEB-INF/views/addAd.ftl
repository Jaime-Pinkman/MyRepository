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

<%--<body onload="show(gg)">
<script>
    function show(invise) {
        $.ajax({
            type: 'post',
            url: '/menu',
            data:{
                invise: invise
            }
        }).done(function (data) {
            let result = document.getElementById("id");
            result.innerHTML = data;
            document.getElementById("image").style.display="none";
        }).fail(function () {
            alert("wrong arguments");
        })
    }
</script>--%>


<div class="wrapper">
    <!-- Sidebar  -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <a href="/CasinoBar"><h3>Casino Bar</h3> </a>
        </div>

        <ul class="list-unstyled components">
            <p>Title</p>
            <li>
                <a href="CasinoBar">Brands</a>
            </li>
            <li>
                <a href="#">Casino</a>
            </li>
            <li>
                <a href="#">Money</a>
            </li>
            <li>
                <a href="catalog">Catalog</a>
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
                        <li class="nav-item ">
                            <a class="nav-link" href="CasinoBar" style="color: blue">to main</a>
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

        <form method="post" action="/addAd">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputTitle">title</label>
                    <input type="text" class="form-control" id="inputTitle" placeholder="Title" name="title">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputProduct_id">product_id</label>
                    <input type="text" class="form-control" id="inputProduct_id" placeholder="Product_id" name="product_id">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputXp">xp</label>
                    <input type="text" class="form-control" id="inputXp" placeholder="Xp" name="xp">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPrice">price</label>
                    <input type="text" class="form-control" id="inputPrice" placeholder="Price" name="price">
                </div>
            </div>
            <div class="form-group">
                <label for="inputImage">image</label>
                <input type="text" class="form-control" id="inputImage" placeholder="Image" name="image">
            </div>
            <button type="submit" class="btn btn-primary">Add ad</button>
        </form>

        <div class="line"></div>

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