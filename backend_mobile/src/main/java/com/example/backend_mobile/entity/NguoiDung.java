package com.example.backend_mobile.entity;

import com.example.backend_mobile.converter.GioiTinhConverter;
import com.example.backend_mobile.converter.TrangThaiNguoiDungConverter;
import com.example.backend_mobile.enums.GioiTinh;
import com.example.backend_mobile.enums.TrangThaiNguoiDung;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "nguoi_dung")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String ten;

    @Column(name = "mat_khau", nullable = false)
    private String matKhau;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "gioi_tinh")
    @Convert(converter = GioiTinhConverter.class)
    private GioiTinh gioiTinh;

    @Column(name = "dia_chi")
    private String diaChi;

    private String avatar;

    @Column(name = "thoi_gian_tao")
    private LocalDateTime thoiGianTao = LocalDateTime.now();

    @Column(name = "trang_thai")
    @Convert(converter = TrangThaiNguoiDungConverter.class)
    private TrangThaiNguoiDung trangThai = TrangThaiNguoiDung.HOAT_DONG;

}