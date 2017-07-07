package com.rxbeauty.model;

import java.util.List;

/**
 * description ：
 * project name：RxBeauty
 * author : Liberation
 * creation date: 2017/7/7 12:50
 *
 * @version 1.0
 */
public class BeautyDetailEntity {

	/**
	 * status : true
	 * total : 65
	 * tngou : [{"count":2408,"fcount":0,"galleryclass":2,"id":800,"img":"/ext/160725/6db46cd2140e27498d518586197a43fd.jpg","rcount":0,"size":8,"time":1469448848000,"title":"韩系气质美女清纯唯美魅惑写真"},{"count":21293,"fcount":0,"galleryclass":2,"id":716,"img":"/ext/160408/b6938f83adf37b1eeb1c320bd5842b88.jpg","rcount":0,"size":23,"time":1460114164000,"title":"清纯女孩松嶋ののか私房诱惑美图"},{"count":12006,"fcount":0,"galleryclass":2,"id":687,"img":"/ext/160310/92093505d160f1a8056ec777cbb8d783.jpg","rcount":0,"size":41,"time":1457573079000,"title":"美女米妮mini大秀巨乳乳沟显清纯 "},{"count":5652,"fcount":0,"galleryclass":2,"id":684,"img":"/ext/160310/93a453490dcda4a4294ace7a8e159fb1.jpg","rcount":0,"size":8,"time":1457572889000,"title":"美女户外清纯靓丽写真"},{"count":6070,"fcount":0,"galleryclass":2,"id":667,"img":"/ext/160301/38c8feeaf15859a543f3a882218c3a14.jpg","rcount":0,"size":28,"time":1456798717000,"title":"日本美女歌手白石麻衣清纯私房照"},{"count":4012,"fcount":0,"galleryclass":2,"id":665,"img":"/ext/160301/1050a224a37030a8e6986cba7b955541.jpg","rcount":0,"size":32,"time":1456798491000,"title":"日本90后美女谷村美月清纯外拍写真图片"},{"count":5139,"fcount":0,"galleryclass":2,"id":651,"img":"/ext/160225/788ea1556d05acc4e0463dd06d53c402.jpg","rcount":0,"size":20,"time":1456359524000,"title":"兔女郎韩雨菲红色制服诱惑写真"},{"count":4441,"fcount":0,"galleryclass":2,"id":648,"img":"/ext/160223/2595cbe31da21b2c9c7aea8e7ee72824.jpg","rcount":0,"size":25,"time":1456205954000,"title":"秀女郎柳侑绮动漫火舞造型写真"},{"count":11406,"fcount":0,"galleryclass":2,"id":642,"img":"/ext/160223/ef343291ab07f29a4cd93aac7405aa2e.jpg","rcount":0,"size":15,"time":1456205639000,"title":"裸体美女思淇Sukiii性感图片"},{"count":4990,"fcount":0,"galleryclass":2,"id":629,"img":"/ext/160217/41c4f1d4eb9f7c9d1ff64f5433305ed8.jpg","rcount":0,"size":24,"time":1455681077000,"title":"日本mm立花美涼护士装更显性感"}]
	 */

	private boolean status;
	private int total;
	private List<TngouBean> tngou;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<TngouBean> getTngou() {
		return tngou;
	}

	public void setTngou(List<TngouBean> tngou) {
		this.tngou = tngou;
	}

	@Override
	public String toString() {
		return "BeautyDetailEntity{" +
				"status=" + status +
				", total=" + total +
				", tngou=" + tngou +
				'}';
	}

	public static class TngouBean {
		@Override
		public String toString() {
			return "TngouBean{" +
					"count=" + count +
					", fcount=" + fcount +
					", galleryclass=" + galleryclass +
					", id=" + id +
					", img='" + img + '\'' +
					", rcount=" + rcount +
					", size=" + size +
					", time=" + time +
					", title='" + title + '\'' +
					'}';
		}

		/**
		 * count : 2408
		 * fcount : 0
		 * galleryclass : 2
		 * id : 800
		 * img : /ext/160725/6db46cd2140e27498d518586197a43fd.jpg
		 * rcount : 0
		 * size : 8
		 * time : 1469448848000
		 * title : 韩系气质美女清纯唯美魅惑写真
		 */



		private int count;
		private int fcount;
		private int galleryclass;
		private int id;
		private String img;
		private int rcount;
		private int size;
		private long time;
		private String title;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getFcount() {
			return fcount;
		}

		public void setFcount(int fcount) {
			this.fcount = fcount;
		}

		public int getGalleryclass() {
			return galleryclass;
		}

		public void setGalleryclass(int galleryclass) {
			this.galleryclass = galleryclass;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public int getRcount() {
			return rcount;
		}

		public void setRcount(int rcount) {
			this.rcount = rcount;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public long getTime() {
			return time;
		}

		public void setTime(long time) {
			this.time = time;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}
