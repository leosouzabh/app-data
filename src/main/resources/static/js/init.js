function callChart(){
	/* chart colors default */
	var $chrt_border_color = "#efefef";
	var $chrt_grid_color = "#DDD"
	var $chrt_main = "#E24913";
	/* red       */
	var $chrt_second = "#6595b4";
	/* blue      */
	var $chrt_third = "#FF9F01";
	/* orange    */
	var $chrt_fourth = "#7e9d3a";
	/* green     */
	var $chrt_fifth = "#BD362F";
	/* dark red  */
	var $chrt_mono = "#000";

	if ($("#site-stats").length) {

		var consumo = [[1, 68], [2, 65], [3, 35], [4, 85]];
		//console.log(pageviews)
		var plot = $.plot($("#site-stats"), [{
			data : consumo,
			label : "Site visitors"
		}], {
			series : {
				lines : {
					show : true,
					lineWidth : 1,
					fill : true,
					fillColor : {
						colors : [{
							opacity : 0.1
						}, {
							opacity : 0.15
						}]
					}
				},
				points : {
					show : true
				},
				shadowSize : 0
			},
			xaxis : {
				ticks: [[1,'Jan/17'],[2,'Fev/17'],[3,'Mar/17 '],[4,'Abr/17 ']],
				//tickLength : 10
			},
			
			yaxis : {
				ticks : 4,
				tickDecimals : 0,
				tickFormatter: function (val, axis) {
			        return val + "mb";
			    }
			},
			grid : {
				hoverable : true,
				clickable : true,
				tickColor : $chrt_border_color,
				borderWidth : 0,
				borderColor : $chrt_border_color,
			},
			tooltip : true,
			tooltipOpts : {
				content : "%s for <b>%x:00 hrs</b> was %y",
				dateFormat : "%y-%0m-%0d",
				defaultTheme : false
			},
			colors : [$chrt_main, $chrt_second],
			
		});

	}
}


function initGraphs(){
	var responsiveHelper_dt_basic = undefined;
	var breakpointDefinition = {
			tablet : 1024,
			phone : 480
		};
	
	$('#dt_basic').dataTable({
		"sDom": "<'dt-toolbar'<'col-xs-12 col-sm-6'f><'col-sm-6 col-xs-12 hidden-xs'l>r>"+
			"t"+
			"<'dt-toolbar-footer'<'col-sm-6 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-6'p>>",
		"autoWidth" : true,
		"preDrawCallback" : function() {
			// Initialize the responsive datatables helper once.
			if (!responsiveHelper_dt_basic) {
				responsiveHelper_dt_basic = new ResponsiveDatatablesHelper($('#dt_basic'), breakpointDefinition);
			}
		},
		"rowCallback" : function(nRow) {
			responsiveHelper_dt_basic.createExpandIcon(nRow);
		},
		"drawCallback" : function(oSettings) {
			responsiveHelper_dt_basic.respond();
		}
	});
	
	$(".js-status-update a").click(function() {
		var selText = $(this).text();
		var $this = $(this);
		$this.parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
		$this.parents('.dropdown-menu').find('li').removeClass('active');
		$this.parent().addClass('active');
	});

	/*
	* TODO: add a way to add more todo's to list
	*/

	// initialize sortable
	$(function() {
		$("#sortable1, #sortable2").sortable({
			handle : '.handle',
			connectWith : ".todo",
			update : countTasks
		}).disableSelection();
	});

	// check and uncheck
	$('.todo .checkbox > input[type="checkbox"]').click(function() {
		var $this = $(this).parent().parent().parent();

		if ($(this).prop('checked')) {
			$this.addClass("complete");

			// remove this if you want to undo a check list once checked
			//$(this).attr("disabled", true);
			$(this).parent().hide();

			// once clicked - add class, copy to memory then remove and add to sortable3
			$this.slideUp(500, function() {
				$this.clone().prependTo("#sortable3").effect("highlight", {}, 800);
				$this.remove();
				countTasks();
			});
		} else {
			// insert undo code here...
		}

	})
	// count tasks
	function countTasks() {

		$('.todo-group-title').each(function() {
			var $this = $(this);
			$this.find(".num-of-tasks").text($this.next().find("li").size());
		});

	}

	
	/* TAB 1: UPDATING CHART */
	// For the demo we use generated data, but normally it would be coming from the server

	var data = [], totalPoints = 200, $UpdatingChartColors = $("#updating-chart").css('color');

	function getRandomData() {
		if (data.length > 0)
			data = data.slice(1);

		// do a random walk
		while (data.length < totalPoints) {
			var prev = data.length > 0 ? data[data.length - 1] : 50;
			var y = prev + Math.random() * 10 - 5;
			if (y < 0)
				y = 0;
			if (y > 100)
				y = 100;
			data.push(y);
		}

		// zip the generated y values with the x values
		var res = [];
		for (var i = 0; i < data.length; ++i)
			res.push([i, data[i]])
		return res;
	}

	// setup control widget
	var updateInterval = 1500;
	$("#updating-chart").val(updateInterval).change(function() {

		var v = $(this).val();
		if (v && !isNaN(+v)) {
			updateInterval = +v;
			$(this).val("" + updateInterval);
		}

	});

	// setup plot
	var options = {
		yaxis : {
			min : 0,
			max : 100
		},
		xaxis : {
			min : 0,
			max : 100
		},
		colors : [$UpdatingChartColors],
		series : {
			lines : {
				lineWidth : 1,
				fill : true,
				fillColor : {
					colors : [{
						opacity : 0.4
					}, {
						opacity : 0
					}]
				},
				steps : false

			}
		}
	};

	var plot = $.plot($("#updating-chart"), [getRandomData()], options);

	/* live switch */
	$('input[type="checkbox"]#start_interval').click(function() {
		if ($(this).prop('checked')) {
			$on = true;
			updateInterval = 1500;
			update();
		} else {
			clearInterval(updateInterval);
			$on = false;
		}
	});

	function update() {
		if ($on == true) {
			plot.setData([getRandomData()]);
			plot.draw();
			setTimeout(update, updateInterval);

		} else {
			clearInterval(updateInterval)
		}

	}

	var $on = false;

	/*end updating chart*/

	/* TAB 2: Social Network  */

	$(function() {
		// jQuery Flot Chart
		var twitter = [[1, 27], [2, 34], [3, 51], [4, 48], [5, 55], [6, 65], [7, 61], [8, 70], [9, 65], [10, 75], [11, 57], [12, 59], [13, 62]], facebook = [[1, 25], [2, 31], [3, 45], [4, 37], [5, 38], [6, 40], [7, 47], [8, 55], [9, 43], [10, 50], [11, 47], [12, 39], [13, 47]], data = [{
			label : "Twitter",
			data : twitter,
			lines : {
				show : true,
				lineWidth : 1,
				fill : true,
				fillColor : {
					colors : [{
						opacity : 0.1
					}, {
						opacity : 0.13
					}]
				}
			},
			points : {
				show : true
			}
		}, {
			label : "Facebook",
			data : facebook,
			lines : {
				show : true,
				lineWidth : 1,
				fill : true,
				fillColor : {
					colors : [{
						opacity : 0.1
					}, {
						opacity : 0.13
					}]
				}
			},
			points : {
				show : true
			}
		}];

		var options = {
			grid : {
				hoverable : true
			},
			colors : ["#568A89", "#3276B1"],
			tooltip : true,
			tooltipOpts : {
				//content : "Value <b>$x</b> Value <span>$y</span>",
				defaultTheme : false
			},
			xaxis : {
				ticks : [[1, "JAN"], [2, "FEB"], [3, "MAR"], [4, "APR"], [5, "MAY"], [6, "JUN"], [7, "JUL"], [8, "AUG"], [9, "SEP"], [10, "OCT"], [11, "NOV"], [12, "DEC"], [13, "JAN+1"]]
			},
			yaxes : {

			}
		};

		var plot3 = $.plot($("#statsChart"), data, options);
	});

	// END TAB 2

	// TAB THREE GRAPH //
	/* TAB 3: Revenew  */

	$(function() {

		var trgt = [[1354586000000, 153], [1364587000000, 658], [1374588000000, 198], [1384589000000, 663], [1394590000000, 801], [1404591000000, 1080], [1414592000000, 353], [1424593000000, 749], [1434594000000, 523], [1444595000000, 258], [1454596000000, 688], [1464597000000, 364]], prft = [[1354586000000, 53], [1364587000000, 65], [1374588000000, 98], [1384589000000, 83], [1394590000000, 980], [1404591000000, 808], [1414592000000, 720], [1424593000000, 674], [1434594000000, 23], [1444595000000, 79], [1454596000000, 88], [1464597000000, 36]], sgnups = [[1354586000000, 647], [1364587000000, 435], [1374588000000, 784], [1384589000000, 346], [1394590000000, 487], [1404591000000, 463], [1414592000000, 479], [1424593000000, 236], [1434594000000, 843], [1444595000000, 657], [1454596000000, 241], [1464597000000, 341]], toggles = $("#rev-toggles"), target = $("#flotcontainer");

		var data = [{
			label : "Target Profit",
			data : trgt,
			bars : {
				show : true,
				align : "center",
				barWidth : 30 * 30 * 60 * 1000 * 80
			}
		}, {
			label : "Actual Profit",
			data : prft,
			color : '#3276B1',
			lines : {
				show : true,
				lineWidth : 3
			},
			points : {
				show : true
			}
		}, {
			label : "Actual Signups",
			data : sgnups,
			color : '#71843F',
			lines : {
				show : true,
				lineWidth : 1
			},
			points : {
				show : true
			}
		}]

		var options = {
			grid : {
				hoverable : true
			},
			tooltip : true,
			tooltipOpts : {
				//content: '%x - %y',
				//dateFormat: '%b %y',
				defaultTheme : false
			},
			xaxis : {
				mode : "time"
			},
			yaxes : {
				tickFormatter : function(val, axis) {
					return "$" + val;
				},
				max : 1200
			}

		};

		plot2 = null;

		function plotNow() {
			var d = [];
			toggles.find(':checkbox').each(function() {
				if ($(this).is(':checked')) {
					d.push(data[$(this).attr("name").substr(4, 1)]);
				}
			});
			if (d.length > 0) {
				if (plot2) {
					plot2.setData(d);
					plot2.draw();
				} else {
					plot2 = $.plot(target, d, options);
				}
			}

		};

		toggles.find(':checkbox').on('change', function() {
			plotNow();
		});
		plotNow()

	});

	/*
	 * VECTOR MAP
	 */

	data_array = {
		"US" : 4977,
		"AU" : 4873,
		"IN" : 3671,
		"BR" : 2476,
		"TR" : 1476,
		"CN" : 146,
		"CA" : 134,
		"BD" : 100
	};

	$('#vector-map').vectorMap({
		map : 'world_mill_en',
		backgroundColor : '#fff',
		regionStyle : {
			initial : {
				fill : '#c4c4c4'
			},
			hover : {
				"fill-opacity" : 1
			}
		},
		series : {
			regions : [{
				values : data_array,
				scale : ['#85a8b6', '#4d7686'],
				normalizeFunction : 'polynomial'
			}]
		},
		onRegionLabelShow : function(e, el, code) {
			if ( typeof data_array[code] == 'undefined') {
				e.preventDefault();
			} else {
				var countrylbl = data_array[code];
				el.html(el.html() + ': ' + countrylbl + ' visits');
			}
		}
	});

	/*
	 * FULL CALENDAR JS
	 */

	if ($("#calendar").length) {
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		var calendar = $('#calendar').fullCalendar({

			editable : true,
			draggable : true,
			selectable : false,
			selectHelper : true,
			unselectAuto : false,
			disableResizing : false,

			header : {
				left : 'title', //,today
				center : 'prev, next, today',
				right : 'month, agendaWeek, agenDay' //month, agendaDay,
			},

			select : function(start, end, allDay) {
				var title = prompt('Event Title:');
				if (title) {
					calendar.fullCalendar('renderEvent', {
						title : title,
						start : start,
						end : end,
						allDay : allDay
					}, true // make the event "stick"
					);
				}
				calendar.fullCalendar('unselect');
			},

			events : [{
				title : 'All Day Event',
				start : new Date(y, m, 1),
				description : 'long description',
				className : ["event", "bg-color-greenLight"],
				icon : 'fa-check'
			}, {
				title : 'Long Event',
				start : new Date(y, m, d - 5),
				end : new Date(y, m, d - 2),
				className : ["event", "bg-color-red"],
				icon : 'fa-lock'
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d - 3, 16, 0),
				allDay : false,
				className : ["event", "bg-color-blue"],
				icon : 'fa-clock-o'
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d + 4, 16, 0),
				allDay : false,
				className : ["event", "bg-color-blue"],
				icon : 'fa-clock-o'
			}, {
				title : 'Meeting',
				start : new Date(y, m, d, 10, 30),
				allDay : false,
				className : ["event", "bg-color-darken"]
			}, {
				title : 'Lunch',
				start : new Date(y, m, d, 12, 0),
				end : new Date(y, m, d, 14, 0),
				allDay : false,
				className : ["event", "bg-color-darken"]
			}, {
				title : 'Birthday Party',
				start : new Date(y, m, d + 1, 19, 0),
				end : new Date(y, m, d + 1, 22, 30),
				allDay : false,
				className : ["event", "bg-color-darken"]
			}, {
				title : 'Smartadmin Open Day',
				start : new Date(y, m, 28),
				end : new Date(y, m, 29),
				className : ["event", "bg-color-darken"]
			}],

			eventRender : function(event, element, icon) {
				if (!event.description == "") {
					element.find('.fc-event-title').append("<br/><span class='ultra-light'>" + event.description + "</span>");
				}
				if (!event.icon == "") {
					element.find('.fc-event-title').append("<i class='air air-top-right fa " + event.icon + " '></i>");
				}
			}
		});

	};

	/* hide default buttons */
	$('.fc-header-right, .fc-header-center').hide();

	// calendar prev
	$('#calendar-buttons #btn-prev').click(function() {
		$('.fc-button-prev').click();
		return false;
	});

	// calendar next
	$('#calendar-buttons #btn-next').click(function() {
		$('.fc-button-next').click();
		return false;
	});

	// calendar today
	$('#calendar-buttons #btn-today').click(function() {
		$('.fc-button-today').click();
		return false;
	});

	// calendar month
	$('#mt').click(function() {
		$('#calendar').fullCalendar('changeView', 'month');
	});

	// calendar agenda week
	$('#ag').click(function() {
		$('#calendar').fullCalendar('changeView', 'agendaWeek');
	});

	// calendar agenda day
	$('#td').click(function() {
		$('#calendar').fullCalendar('changeView', 'agendaDay');
	});

	/*
	 * CHAT
	 */

	$.filter_input = $('#filter-chat-list');
	$.chat_users_container = $('#chat-container > .chat-list-body')
	$.chat_users = $('#chat-users')
	$.chat_list_btn = $('#chat-container > .chat-list-open-close');
	$.chat_body = $('#chat-body');

	/*
	* LIST FILTER (CHAT)
	*/

	// custom css expression for a case-insensitive contains()
	jQuery.expr[':'].Contains = function(a, i, m) {
		return (a.textContent || a.innerText || "").toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
	};

	function listFilter(list) {// header is any element, list is an unordered list
		// create and add the filter form to the header

		$.filter_input.change(function() {
			var filter = $(this).val();
			if (filter) {
				// this finds all links in a list that contain the input,
				// and hide the ones not containing the input while showing the ones that do
				$.chat_users.find("a:not(:Contains(" + filter + "))").parent().slideUp();
				$.chat_users.find("a:Contains(" + filter + ")").parent().slideDown();
			} else {
				$.chat_users.find("li").slideDown();
			}
			return false;
		}).keyup(function() {
			// fire the above change event after every letter
			$(this).change();

		});

	}

	// on dom ready
	listFilter($.chat_users);

	// open chat list
	$.chat_list_btn.click(function() {
		$(this).parent('#chat-container').toggleClass('open');
	})

	$.chat_body.animate({
		scrollTop : $.chat_body[0].scrollHeight
	}, 500);
}