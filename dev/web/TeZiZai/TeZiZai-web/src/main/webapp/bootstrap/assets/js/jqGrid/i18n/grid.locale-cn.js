;
(function ($) {
    /**
     * jqGrid English Translation
     * Tony Tomov tony@trirand.com
     * http://trirand.com/blog/
     * Dual licensed under the MIT and GPL licenses:
     * http://www.opensource.org/licenses/mit-license.php
     * http://www.gnu.org/licenses/gpl.html
     **/
    $.jgrid = $.jgrid || {};
    $.extend($.jgrid, {
        defaults: {
            recordtext: "当前显示{0}到{1}条/总共{2}条记录",
            emptyrecords: "记录为空",
            loadtext: "加载中...",
            pgtext: "第{0}页/共{1}页"
        },
        search: {
            caption: "搜索...",
            Find: "查找",
            Reset: "重置",
//            odata: [
//                { oper: 'eq', text: '相等'},
//                { oper: 'ne', text: '不相等'},
//                { oper: 'lt', text: 'less'},
//                { oper: 'le', text: 'less or equal'},
//                { oper: 'gt', text: 'greater'},
//                { oper: 'ge', text: 'greater or equal'},
//                { oper: 'bw', text: 'begins with'},
//                { oper: 'bn', text: 'does not begin with'},
//                { oper: 'in', text: 'is in'},
//                { oper: 'ni', text: 'is not in'},
//                { oper: 'ew', text: 'ends with'},
//                { oper: 'en', text: 'does not end with'},
//                { oper: 'cn', text: 'contains'},
//                { oper: 'nc', text: 'does not contain'}
//            ],
            odata: [
                { oper: 'cn', text: '包含'},
                { oper: 'eq', text: '等于'},
                { oper: 'in', text: '大于'},
                { oper: 'ni', text: '小于'},
                { oper: 'ne', text: '不等于'},
                { oper: 'nc', text: '不包含'}
            ],
            groupOps: [
                { op: "AND", text: "多条件联合筛选" },
                { op: "OR", text: "多条件分别筛选" }
            ]
        },
        edit: {
            addCaption: "添加记录",
            editCaption: "修改记录",
            bSubmit: "提交",
            bCancel: "取消",
            bClose: "关闭",
            saveData: "数据已经改变! 需要保存么?",
            bYes: "是",
            bNo: "否",
            bExit: "取消",
            msg: {
                required: "请求失败",
                number: "请输入数字格式的值",
                minValue: "value must be greater than or equal to ",
                maxValue: "value must be less than or equal to",
                email: "邮件格式不正确",
                integer: "请输入数字格式的值",
                date: "请输入日期格式的值",
                url: "URL格式不正确，前缀应该是 'http://' 或 'https://'",
                nodefined: " 没有定义！",
                novalue: " return value is required!",
                customarray: "Custom function should return array!",
                customfcheck: "Custom function should be present in case of custom checking!"

            }
        },
        view: {
            caption: "显示记录",
            bClose: "关闭"
        },
        del: {
            caption: "删除",
            msg: "您确定要删除选中的行么？",
            bSubmit: "删除",
            bCancel: "取消"
        },
        nav: {
            edittext: "",
            edittitle: "编辑",
            addtext: "",
            addtitle: "添加记录",
            deltext: "",
            deltitle: "删除选中行",
            searchtext: "",
            searchtitle: "查找",
            refreshtext: "",
            refreshtitle: "重新加载",
            alertcap: "警告",
            alerttext: "请先选择指定行之后再操作",
            viewtext: "",
            viewtitle: "显示详情"
        },
        col: {
            caption: "请选择",
            bSubmit: "确定",
            bCancel: "取消"
        },
        errors: {
            errcap: "出错了",
            nourl: "为设置URL",
            norecords: "没有记录",
            model: "Length of colNames <> colModel!"
        },
        formatter: {
            integer: {thousandsSeparator: ",", defaultValue: '0'},
            number: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, defaultValue: '0.00'},
            currency: {decimalSeparator: ".", thousandsSeparator: ",", decimalPlaces: 2, prefix: "", suffix: "", defaultValue: '0.00'},
            date: {
                dayNames: [
                    "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat",
                    "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
                ],
                monthNames: [
                    "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
                    "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
                ],
                AmPm: ["am", "pm", "AM", "PM"],
                S: function (j) {
                    return j < 11 || j > 13 ? ['st', 'nd', 'rd', 'th'][Math.min((j - 1) % 10, 3)] : 'th';
                },
                srcformat: 'Y-m-d',
                newformat: 'n/j/Y',
                parseRe: /[Tt\\\/:_;.,\t\s-]/,
                masks: {
                    // see http://php.net/manual/en/function.date.php for PHP format used in jqGrid
                    // and see http://docs.jquery.com/UI/Datepicker/formatDate
                    // and https://github.com/jquery/globalize#dates for alternative formats used frequently
                    // one can find on https://github.com/jquery/globalize/tree/master/lib/cultures many
                    // information about date, time, numbers and currency formats used in different countries
                    // one should just convert the information in PHP format
                    ISO8601Long: "Y-m-d H:i:s",
                    ISO8601Short: "Y-m-d",
                    // short date:
                    //    n - Numeric representation of a month, without leading zeros
                    //    j - Day of the month without leading zeros
                    //    Y - A full numeric representation of a year, 4 digits
                    // example: 3/1/2012 which means 1 March 2012
                    ShortDate: "n/j/Y", // in jQuery UI Datepicker: "M/d/yyyy"
                    // long date:
                    //    l - A full textual representation of the day of the week
                    //    F - A full textual representation of a month
                    //    d - Day of the month, 2 digits with leading zeros
                    //    Y - A full numeric representation of a year, 4 digits
                    LongDate: "l, F d, Y", // in jQuery UI Datepicker: "dddd, MMMM dd, yyyy"
                    // long date with long time:
                    //    l - A full textual representation of the day of the week
                    //    F - A full textual representation of a month
                    //    d - Day of the month, 2 digits with leading zeros
                    //    Y - A full numeric representation of a year, 4 digits
                    //    g - 12-hour format of an hour without leading zeros
                    //    i - Minutes with leading zeros
                    //    s - Seconds, with leading zeros
                    //    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
                    FullDateTime: "l, F d, Y g:i:s A", // in jQuery UI Datepicker: "dddd, MMMM dd, yyyy h:mm:ss tt"
                    // month day:
                    //    F - A full textual representation of a month
                    //    d - Day of the month, 2 digits with leading zeros
                    MonthDay: "F d", // in jQuery UI Datepicker: "MMMM dd"
                    // short time (without seconds)
                    //    g - 12-hour format of an hour without leading zeros
                    //    i - Minutes with leading zeros
                    //    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
                    ShortTime: "g:i A", // in jQuery UI Datepicker: "h:mm tt"
                    // long time (with seconds)
                    //    g - 12-hour format of an hour without leading zeros
                    //    i - Minutes with leading zeros
                    //    s - Seconds, with leading zeros
                    //    A - Uppercase Ante meridiem and Post meridiem (AM or PM)
                    LongTime: "g:i:s A", // in jQuery UI Datepicker: "h:mm:ss tt"
                    SortableDateTime: "Y-m-d\\TH:i:s",
                    UniversalSortableDateTime: "Y-m-d H:i:sO",
                    // month with year
                    //    Y - A full numeric representation of a year, 4 digits
                    //    F - A full textual representation of a month
                    YearMonth: "F, Y" // in jQuery UI Datepicker: "MMMM, yyyy"
                },
                reformatAfterEdit: false
            },
            baseLinkUrl: '',
            showAction: '',
            target: '',
            checkbox: {disabled: true},
            idName: 'id'
        }
    });
})(jQuery);