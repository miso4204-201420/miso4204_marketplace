/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/
define(['delegate/_productDelegate'], function() {
    App.Delegate.ProductDelegate = App.Delegate._ProductDelegate.extend({
<<<<<<< HEAD
        search: function(model, callback, callbackError){
            $.ajax({
                  url: '/product.services/webresources/products/search/',
                  type: 'GET',
                  data: $.param(model.toJSON()),
=======
        search: function(model, callback){
            $.ajax({
                  url: '/product.services/products',
                  type: 'GET',
                  data: $.param(model),
>>>>>>> maincurso/master
                  contentType: 'application/json'
             }).done(_.bind(function(data) {
                 console.log("_bind");
                 callback.call(callback, data);
             }, this)).error(_.bind(function(data) {
<<<<<<< HEAD
                 callbackError(data);
                 console.log("callback error");                 
=======
                console.log("callback error");                 
>>>>>>> maincurso/master
             }, this));
        },
        searchById: function(productId, callback){
            $.ajax({
                  url: '/product.services/products/' + productId,
                  type: 'GET',
                  data: {},
                  contentType: 'application/json'
             }).done(_.bind(function(data) {
                 console.log("_bind");
                 callback.call(callback, data);
             }, this)).error(_.bind(function(data) {
                console.log("callback error");                 
             }, this));
        },
        insert: function(product, callback){
            $.ajax({
                  url: '/product.services/products',
                  type: 'POST',
                  data: product,
                  contentType: 'application/json'
             }).done(_.bind(function(data) {
                 console.log("_bind");
                 callback.call(callback, data);
             }, this)).error(_.bind(function(data) {
                console.log("callback error");                 
             }, this));
        },
        update: function(product, callback){
            $.ajax({
                  url: '/product.services/products',
                  type: 'PUT',
                  data: product,
                  contentType: 'application/json'
             }).done(_.bind(function(data) {
                 console.log("_bind");
                 callback.call(callback, data);
             }, this)).error(_.bind(function(data) {
                console.log("callback error");                 
             }, this));
        }, searchByCategory: function(categoryId, callback){
            $.ajax({
                  url: '/product.services/products/category/' + categoryId,
                  type: 'GET',
                  data: {},
                  contentType: 'application/json'
             }).done(_.bind(function(data) {
                 console.log("_bind");
                 callback.call(callback, data);
             }, this)).error(_.bind(function(data) {
                console.log("callback error");                 
             }, this));
        }
    });
});
//Modificado por Sergio Rios 20141117