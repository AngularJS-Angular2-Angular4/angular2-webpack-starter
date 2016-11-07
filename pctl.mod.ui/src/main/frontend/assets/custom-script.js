(function(){
                $('.new-list-view .list-view-item div:first-child').on('click', function(){
                                $(this).nextAll('section').toggle();
                });

                //smoothscroll
                $(window).scroll(function () { 
                   //   console.log($(window).scrollTop())
                    if ($(window).scrollTop() > 40) {
                      $('.nav-tabs').addClass('navbar-fixed');
                    }
                    if ($(window).scrollTop() < 40) {
                      $('.nav-tabs').removeClass('navbar-fixed');
                    }
                });


                $(document).on("scroll", onScroll);
    
    $('.nav-tabs a[href^="#"]').on('click', function (e) {
        e.preventDefault();
        $(document).off("scroll");
        
        $('.nav-tabs li').each(function () {
            $(this).removeClass('active');
        })
        $(this).parent().addClass('active');
      
        var target = this.hash,
            menu = target;
        $target = $(target);
        $('html, body').stop().animate({
            'scrollTop': $target.offset().top+2
        }, 500, 'swing', function () {
            window.location.hash = target;
            $(document).on("scroll", onScroll);
        });
    });


                function onScroll(event){
                    var scrollPos = $(document).scrollTop();
                    $('.nav-tabs a').each(function () {
                        var currLink = $(this);
                        var refElement = $(currLink.attr("href"));

                //ToolTip for Products Description
                $("#tool-trigger0").bind({
                   mousemove : changeTooltipPosition,
                   mouseenter : showTooltip,
                   mouseleave: hideTooltip
                });
                $("#tool-trigger1").bind({
                   mousemove : changeTooltipPosition,
                   mouseenter : showTooltip1,
                   mouseleave: hideTooltip
                });
                $("#tool-trigger2").bind({
                   mousemove : changeTooltipPosition,
                   mouseenter : showTooltip2,
                   mouseleave: hideTooltip
                });
                $("#tool-trigger3").bind({
                   mousemove : changeTooltipPosition,
                   mouseenter : showTooltip3,
                   mouseleave: hideTooltip
                });
                                          //      console.log(refElement);
                        if (refElement.position().top < scrollPos + 180 && refElement.position().top + refElement.height() > scrollPos + 180) {
                            $('.nav-tabs ul li').removeClass("active");
                            currLink.parent().addClass("active");
                        }
                        else{
                            currLink.parent().removeClass("active");
                        }
                    });
                }


                //tooltip code
                var changeTooltipPosition = function(event) {
                  var tooltipX = event.pageX - 8;
                  var tooltipY = event.pageY + 8;
                  $('div.custom-tooltip').css({top: tooltipY, left: tooltipX});
                };

               var showTooltip = function(event) {
                    var content =  document.getElementById('SDWANBASIC').value;
                  $('div.custom-tooltip').remove();
                  $('<div class="custom-tooltip"><h5>SD-WAN BASIC</h5>'+content+'</div>')
                    .appendTo('body');
                  changeTooltipPosition(event);
                };
                var showTooltip1 = function(event) {
                    var content =  document.getElementById('SDWANBASICHA').value;
                  $('div.custom-tooltip').remove();
                  $('<div class="custom-tooltip"><h5>SD-WAN BASIC HA</h5>'+content+'</div>')
                    .appendTo('body');
                  changeTooltipPosition(event);
                };
                var showTooltip2 = function(event) {
                    var content =  document.getElementById('SDWANPREMIUM').value;
                  $('div.custom-tooltip').remove();
                  $('<div class="custom-tooltip"><h5>SD-WAN PREMIUM</h5>'+content+'</div>')
                    .appendTo('body');
                  changeTooltipPosition(event);
                };
                var showTooltip3 = function(event) {
                    var content =  document.getElementById('SDWANPREMIUMHA').value;
                  $('div.custom-tooltip').remove();
                  $('<div class="custom-tooltip"><h5>SD-WAN PREMIUM HA</h5>'+content+'</div>')
                    .appendTo('body');
                  changeTooltipPosition(event);
                };

                var hideTooltip = function() {
                   $('div.custom-tooltip').remove();
                };
})();
