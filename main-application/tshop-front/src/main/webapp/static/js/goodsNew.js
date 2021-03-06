/**
 * Created by Роднуля on 11.04.2017.
 */
(function () {

    var $errorMessageSpan = jQuery("#errorMessage");
    var $categorySelectDiv = jQuery(".goods-categories");

    var goodsStructure = {};
    jQuery.ajax({
        url: ctx + "/data/goods/structure",
        success: function (goods) {
            goodsStructure = goods;
        }
    });

    var createCategorySelect = function (categories) {
        var $select = jQuery("<select class='goods-categories-select form-control'></select>").attr("multiple", true);
        for (var i = 0; i < categories.length; i++) {
            $select.append(jQuery("<option value='" + categories[i].id + "'></option>").text(categories[i].name));
        }

        $categorySelectDiv.append($select);
    }

    jQuery.ajax({
        url: ctx + "/data/categories",
        success: function (data) {
            createCategorySelect(data);
        },
        error: function (error) {
            $errorMessageSpan.text("Problem with getting categories");
        }
    });

    jQuery(".goods-rtrn-btn").click(function () {
        window.location.href = ctx+"/goods";
    })

    // jQuery(".goods-save-btn").click(function () {
    //     var goods = {};
    //     goods.model = jQuery(".goods-model").val();
    //     goods.price = jQuery(".goods-price").val();
    //     goods.enginetype = jQuery(".goods-enginetype").val();
    //     goods.color = jQuery(".goods-colour").val();
    //     goods.transmission = jQuery(".goods-transmission").val();
    //     goods.weight = jQuery(".goods-weight").val();
    //     goods.volume = jQuery(".goods-volume").val();
    //     goods.quantity = jQuery(".goods-quantity").val();
    //     goods.categories = [];
    //     $categorySelectDiv.find("option:selected").each(function (i) {
    //         goods.categories[i] = jQuery(this).val();
    //     });
    //
    //     jQuery.ajax({
    //         url: ctx + "/data/goods",
    //         type: "POST",
    //         data: JSON.stringify(goods),
    //         dataType: "json",
    //         contentType: "application/json",
    //         success: function () {
    //             window.location.href=ctx+"/goods";
    //         },
    //         error: function () {
    //             $errorMessageSpan.text("Problem with adding goods");
    //         }
    //     });
    //
    // });

    jQuery(".goods-save-btn").click(function () {
        var goods = {};
        // goods.id = goodsIdVal;
        for(var prop in goodsStructure){
            var elem = jQuery(".goods-"+prop);
            if(elem){
                goods[prop] = elem.val();
            }
        };
        goods.categories = [];
        $categorySelectDiv.find("option:selected").each(function (i) {
            goods.categories[i] = jQuery(this).val();
        });

        jQuery.ajax({
            url: ctx + "/data/goods",
            type: "POST",
            data: JSON.stringify(goods),
            dataType: "json",
            contentType: "application/json",
            success: function () {
                window.location.href = ctx + "/goods";
            },
            error: function () {
                $errorMessageSpan.text("Problem with saving goods");
            }
        });

    });


})()
