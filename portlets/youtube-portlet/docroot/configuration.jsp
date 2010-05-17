<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
%>

<%@ include file="init.jsp" %>

<style type="text/css">
	#<portlet:namespace />preview {
		-moz-border-radius: 4px;
		-webkit-border-radius: 4px;
		background: #d0d0d0 url(/youtube-portlet/images/preview_bg.png) no-repeat center center;
		border-radius: 4px;
		height: 0;
		width: 0;
	}

	#<portlet:namespace />controls {
		width: 40em;
	}

	#<portlet:namespace />fm select {
		padding: 4px;
	}

	#<portlet:namespace />fm .aui-field-inline {
		vertical-align: text-top;
	}

	#<portlet:namespace />fm .aui-field-label {
		vertical-align: bottom;
	}

	#<portlet:namespace />fm .aui-field-row .aui-field-content {
		margin-right: 1em;
	}

	#<portlet:namespace />fm .aui-field-input-choice {
		margin-right: 0.3em;
	}

	#<portlet:namespace />fm .url .aui-field-input {
		width: 30em;
	}

	#<portlet:namespace />fm .height .aui-field-input,
	#<portlet:namespace />fm .start-time .aui-field-input,
	#<portlet:namespace />fm .width .aui-field-input {
		width: 5em;
	}

	#<portlet:namespace />fm .aui-colorpicker-trigger {
		vertical-align: top;
	}

	#<portlet:namespace />fm .aui-field-text .aui-field-label,
	#<portlet:namespace />fm .aui-field-select .aui-field-label {
		display: block;
	}

	.lfr-panel-content {
		padding: 0.1em;
	}
</style>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

	<aui:layout>
		<aui:column id='<%= renderResponse.getNamespace() + "controls" %>'>
			<div class="aui-field-row">
				<aui:input cssClass="url" inlineField="true" label="url" name="url" value="<%= url %>" />

				<aui:input cssClass="start-time" inlineField="true" label="start-time" name="startTime" value="<%= startTime %>" />
			</div>

			<liferay-ui:panel-container extended="<%= true %>" id="youtubePanelContainer" persistState="<%= true %>">
				<liferay-ui:panel collapsible="<%= true %>" defaultState="closed" extended="<%= true %>" id="lookAndFeelPanel" persistState="<%= true %>" title='<%= LanguageUtil.get(pageContext, "look-and-feel") %>'>
					<div class="aui-field-row">
						<aui:select label="preset-frame-size" name="presetSize" inlineField="true" cssClass="preset-size">
							<aui:option>Custom</aui:option>
							<aui:option label="Standard 360 4:3" selected='<%= presetSize.equals("480x360") %>' value="480x360" />
							<aui:option label="Standard 360 16:9" selected='<%= presetSize.equals("640x360") %>' value="640x360" />
							<aui:option label="Enhanced 480 4:3" selected='<%= presetSize.equals("640x480") %>' value="640x480" />
							<aui:option label="Enhanced 480 16:9" selected='<%= presetSize.equals("854x480") %>' value="854x480" />
							<aui:option label="HD 720 4:3" selected='<%= presetSize.equals("960x720") %>' value="960x720" />
							<aui:option label="HD 720 16:9" selected='<%= presetSize.equals("1280x720") %>' value="1280x720" />
							<aui:option label="Full HD 1080 4:3" selected='<%= presetSize.equals("1440x1080") %>' value="1440x1080" />
							<aui:option label="Full HD 1080 16:9" selected='<%= presetSize.equals("1920x1080") %>' value="1920x1080" />
						</aui:select>

						<aui:input cssClass="width" inlineField="true" label="frame-width" name="width" value="<%= width %>" />

						<aui:input cssClass="height" inlineField="true" label="frame-height" name="height" value="<%= height %>" />
					</div>

					<div class="aui-field-row">
						<aui:input cssClass="player-color" inlineField="true" label="player-color" name="playerColor" value="<%= playerColor %>" />

						<aui:input cssClass="border-color" inlineField="true" label="border-color" name="borderColor" value="<%= borderColor %>" />
					</div>

					<aui:input cssClass="show-thicker-border" inlineField="true" label="show-thicker-border" name="showThickerBorder" value="<%= showThickerBorder %>" type="checkbox" />
				</liferay-ui:panel>

				<liferay-ui:panel collapsible="<%= true %>" defaultState="closed" extended="<%= true %>" id="optionsPanel" persistState="<%= true %>" title='<%= LanguageUtil.get(pageContext, "options") %>'>
					<div class="aui-field-row">
						<aui:input cssClass="hd" inlineField="true" label="hd-video" name="hd" value="<%= hd %>" type="checkbox" />

						<aui:input cssClass="autoplay" inlineField="true" label="auto-play" name="autoplay" value="<%= autoplay %>" type="checkbox" />

						<aui:input cssClass="loop" inlineField="true" label="loop" name="loop" value="<%= loop %>" type="checkbox" />

						<aui:input cssClass="enable-fullscreen" inlineField="true" label="enable-fullscreen-option" name="enableFullscreen" value="<%= enableFullscreen %>" type="checkbox" />
					</div>

					<aui:input checked="<%= enableKeyboardControls %>" cssClass="enable-keyboard-controls" inlineField="true" label="enable-keyboard-controls" name="enableKeyboardControls" value="<%= enableKeyboardControls %>" type="checkbox" />
				</liferay-ui:panel>

				<liferay-ui:panel collapsible="<%= true %>" defaultState="closed" extended="<%= true %>" id="metaInfoPanel" persistState="<%= true %>" title='<%= LanguageUtil.get(pageContext, "meta-info") %>'>
					<div class="aui-field-row">
						<aui:input cssClass="show-info" inlineField="true" label="show-video-info" name="showInfo" value="<%= showInfo %>" type="checkbox" />

						<aui:input cssClass="enable-enhanced-genie-menu" helpMessage="enhanced-genie-menu-help" inlineField="true" label="enable-enhanced-genie-menu" name="enableEnhancedGenieMenu" value="<%= enableEnhancedGenieMenu %>" type="checkbox" />

						<aui:input cssClass="enable-search" inlineField="true" label="enable-search" name="enableSearch" value="<%= enableSearch %>" type="checkbox" />
					</div>

					<div class="aui-field-row">
						<aui:select label="annotations" name="annotations" value="<%= annotations %>" inlineField="true" cssClass="annotations">
							<aui:option label="show-by-default" selected="<%= annotations == 1 %>" value="1" />
							<aui:option label="do-not-show-by-default" selected="<%= annotations == 3 %>" value="3" />
						</aui:select>

						<aui:select label="closed-captioning" name="closedCaptioning" inlineField="true" cssClass="closed-captioning">
							<aui:option label="show-by-default" selected="<%= closedCaptioning == 1 %>" value="1" />
							<aui:option label="do-not-show-by-default" selected="<%= closedCaptioning == 0 %>" value="0" />
						</aui:select>
					</div>
				</liferay-ui:panel>
			</liferay-ui:panel-container>
		</aui:column>

		<aui:column>
			<div class="aui-field-wrapper-content" id="<portlet:namespace />preview"></div>
		</aui:column>
	</aui:layout>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="reset" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-color-picker,aui-datatype,aui-swf">
	var encodeHex = function (hex) {
			return (hex) ? '0x' + hex.replace('#', '').replace(/^(.)(.)(.)$/, '$1$1$2$2$3$3').toLowerCase() : '';
		},
		urlToVideoId = function (url) {
			return url.replace(/.*v=([A-z0-9]+).*/, '$1');
		},
		createPlayer = function () {
			var id = urlToVideoId(urlNode.val()),
				height = parseInt(heightNode.val(), 10) || 0,
				maxWidth = (formNode.get('clientWidth') || formNode.get('scrollWidth')) - (controlsNode.get('clientWidth') || controlsNode.get('scrollWidth')) - 15,
				playerOptions = {
					border: showThickerBorderNode.val(),
					cc_load_policy: closedCaptioningNode.val(),
					color1: encodeHex(borderColorNode.val()),
					color2: encodeHex(playerColorNode.val()),
					disablekb: (!A.DataType.Boolean.parse(enableKeyboardControlsNode.val())).toString(),
					egm: enableEnhancedGenieMenuNode.val(),
					fs: enableFullscreenNode.val(),
					hd: hdNode.val(),
					iv_load_policy: annotationsNode.val(),
					rel: enableEnhancedGenieMenuNode.val(),
					showinfo: showInfoNode.val(),
					showsearch: enableSearchNode.val(),
					start: startTimeNode.val()
				},
				playerOptionsCompiled,
				ratio,
				value,
				width = parseInt(widthNode.val(), 10) || 0,
				x;

			ratio = Math.min(maxWidth / width, 1);
			height = Math.floor(height * ratio);
			width = Math.floor(width * ratio);

			playerOptionsCompiled = [swfURL + id];

			for (x in playerOptions) {
				if (playerOptions[x]) {
					playerOptionsCompiled.push(x + '=' + playerOptions[x].replace(/^true$/, '1').replace(/^false$/, '0'));
				}
			}

			if (id) {
				previewNode.setContent(['<a href="', watchURL, id, '" rel="external" title="watch-this-video-at-youtube"><img src="', imageURL.replace('<%= id %>', id), '" alt="youtube-video" width="100%" height="100%" /></a>'].join(''));

				new A.SWF(
					{
						boundingBox: previewNode,
						height: height,
						url: playerOptionsCompiled.join('&'),
						width: width,
						version: 0
					}
				).render();
			}
			else {
				previewNode.setStyles(
					{
						height: height,
						width: width
					}
				);
			}
		},
		presetChange = function (e) {
			if (this.val().indexOf('x') < 0) return;

			var dimensions = this.val().split('x');

			heightNode.val(dimensions[1]);
			widthNode.val(dimensions[0]);

			createPlayer();
		};

	var allInputsNode = A.all('#<portlet:namespace />fm input');

	var formNode = A.one('#<portlet:namespace />fm');

	var controlsNode = A.one('#<portlet:namespace />controls');
	var previewNode = A.one('#<portlet:namespace />preview');

	var annotationsNode = A.one('#<portlet:namespace />annotations');
	var borderColorNode = A.one('#<portlet:namespace />borderColor');
	var closedCaptioningNode = A.one('#<portlet:namespace />closedCaptioning');
	var enableEnhancedGenieMenuNode = A.one('#<portlet:namespace />enableEnhancedGenieMenu');
	var enableFullscreenNode = A.one('#<portlet:namespace />enableFullscreen');
	var enableKeyboardControlsNode = A.one('#<portlet:namespace />enableKeyboardControls');
	var enableSearchNode = A.one('#<portlet:namespace />enableSearch');
	var hdNode = A.one('#<portlet:namespace />hd');
	var heightNode = A.one('#<portlet:namespace />height');
	var playerColorNode = A.one('#<portlet:namespace />playerColor');
	var presetSizeNode = A.one('#<portlet:namespace />presetSize');
	var showInfoNode = A.one('#<portlet:namespace />showInfo');
	var showThickerBorderNode = A.one('#<portlet:namespace />showThickerBorder');
	var startTimeNode = A.one('#<portlet:namespace />startTime');
	var urlNode = A.one('#<portlet:namespace />url');
	var widthNode = A.one('#<portlet:namespace />width');

	var imageURL = '<%= imageURL %>';
	var swfURL = '<%= swfURL %>';
	var watchURL = '<%= watchURL %>';

	A.on(
		'change',
		function (e) {
			createPlayer();
		},
		allInputsNode
	);

	presetSizeNode.on(
		{
			change: presetChange,
			keypress: presetChange
		}
	);

	A.on(
		'change',
		function (e) {
			presetSizeNode.val('');

			presetSizeNode.val(widthNode.val() + 'x' + heightNode.val());
		},
		heightNode
	);

	A.on(
		'change',
		function (e) {
			presetSizeNode.val('');

			presetSizeNode.val(widthNode.val() + 'x' + heightNode.val());
		},
		widthNode
	);

	A.on(
		'click',
		function (e) {
			e.preventDefault();

			submitForm(document.<portlet:namespace />fm);
		},
		'input.aui-button-input-submit'
	);

	A.on(
		'windowresize',
		function (e) {
			createPlayer();
		}
	);

	new A.ColorPicker(
		{
			after: {
				colorChange: function (e) {
					playerColorNode.val('#' + this.get('hex'));

					createPlayer();
				}
			},
			constrain: true,
			preventOverlap: true,
			triggerParent: playerColorNode.get('parentNode')
		}
	).render();

	new A.ColorPicker(
		{
			after: {
				colorChange: function (e) {
					borderColorNode.val('#' + this.get('hex'));

					createPlayer();
				}
			},
			constrain: true,
			preventOverlap: true,
			triggerParent: borderColorNode.get('parentNode')
		}
	).render();

	createPlayer();
</aui:script>