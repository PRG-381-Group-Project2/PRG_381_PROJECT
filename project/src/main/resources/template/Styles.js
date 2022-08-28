$(function () {
  var template = Handlebars.compile($("#list-template").html()),
    context = {
      items: [
        {
          column1: "1.1",
          column2: "1.2",
          column3: "1.3",
          column4: "1.4",
        },

        {
          column1: "2.1",
          column2: "2.2",
          column3: "2.3",
          column4: "2.4",
        },

        {
          column1: "3.1",
          column2: "3.2",
          column3: "3.3",
          column4: "3.4",
        },
      ],
    };

  $(".items-holder").html(template(context));

  /* dropdown */
  // click event outside button or menu
  $(document).on("click", function (e) {
    $("*[data-toggle=dropdown].open").each(function () {
      var $_button = $(this),
        $_buttonFor = $_button.attr("data-toggle-for"),
        $_menu = $("#" + $_buttonFor);

      if (
        !$(e.target).closest($_button).length &&
        !$(event.target).closest($_menu).length
      ) {
        // enable scrolling event
        $("body").off("mousewheel");
        // Hide the menus.
        $_button.removeClass("open");
        $_menu.removeClass("open");
      }
    });
  });

  // toggle button
  $("*[data-toggle=dropdown]").on("click", function (e) {
    e.preventDefault();

    var $button = $(this),
      $buttonFor = $button.attr("data-toggle-for"),
      $menu = $("#" + $buttonFor);

    if ($button.hasClass("open") || $menu.hasClass("open")) {
      $button.removeClass("open");
      $menu.removeClass("open");
      // enable scrolling event
      $("body").off("mousewheel");
    } else {
      $button.addClass("open");
      $menu.addClass("open");

      // disable scrolling event
      $("body").on("mousewheel", function (e) {
        e.preventDefault();
        e.stopPropagation();
      });
    }

    return false;
  });
});
