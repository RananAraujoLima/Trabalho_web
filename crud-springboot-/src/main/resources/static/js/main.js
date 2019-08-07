$(document).ready(function(){
    $('.next').on('click', function(){
      var currentImg = $('.active');
      var nextImg = currentImg.next();
  
      if(nextImg.length){
        currentImg.removeClass('active').css('z-index', -10);
        nextImg.addClass('active').css('z-index', 10);
      }
    });
  
    $('.prev').on('click', function(){
      var currentImg = $('.active');
      var prevImg = currentImg.prev();
  
      if(prevImg.length){
        currentImg.removeClass('active').css('z-index', -10);
        prevImg.addClass('active').css('z-index', 10);
      }
    });
  });
   function gerar (){
    

    window.location.replace("outrospratos.html");
    
    }
   
    function myFunction() {
      var dots = document.getElementById("dots");
      var moreText = document.getElementById("more");
      var btnText = document.getElementById("myBtn");
    
      if (dots.style.display === "none") {
        dots.style.display = "inline";
        btnText.innerHTML = "Ver Mais"; 
        moreText.style.display = "none";
      } else {
        dots.style.display = "none";
        btnText.innerHTML = "Ver menos"; 
        moreText.style.display = "inline";
      }
    }