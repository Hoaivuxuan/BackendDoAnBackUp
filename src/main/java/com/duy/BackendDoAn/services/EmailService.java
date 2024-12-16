package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.dtos.EmailDTO;
import com.duy.BackendDoAn.models.Hotel;
import com.duy.BackendDoAn.repositories.HotelRepository;
import com.duy.BackendDoAn.responses.bookingRooms.BookingRoomResponse;
import com.duy.BackendDoAn.responses.bookingRooms.SeperatedRoomResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmailService {
    private final HotelRepository hotelRepository;
    @Autowired
    private JavaMailSender mailSender;

    public void sendBookingEmail(BookingRoomResponse bookingRoomResponse) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("no-reply@hotelbooking.com", "Hotel Booking");
            helper.setTo(bookingRoomResponse.getCustomerResponse().getEmail());
            helper.setSubject("Booking Successfully");
            String emailContent = buildEmailBody(bookingRoomResponse);

            helper.setText(emailContent, true);  // true để xác định đây là HTML content

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error sending password reset email: " + e.getMessage());
        }
    }

    public void sendPasswordResetEmail(String toEmail, String newPassword) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            // Thêm thông tin người gửi và tiêu đề
            helper.setFrom("no-reply@hotelbooking.com", "Hotel Booking");
            helper.setTo(toEmail);
            helper.setSubject("Password Reset Notification");

            // Nội dung email dưới dạng HTML
            String emailContent = "<html><body>"
                    + "<h2>Password Reset Notification</h2>"
                    + "<p>Your password has been reset successfully. Your new password is:</p>"
                    + "<h3 style='color:#007bff;'>" + newPassword + "</h3>"
                    + "<p>Please change your password immediately after logging in for security purposes.</p>"
                    + "<p>Thank you,<br>Hotel Booking</p>"
                    + "</body></html>";

            helper.setText(emailContent, true); // true để gửi nội dung HTML

            mailSender.send(message);

            System.out.println("Password reset email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error sending password reset email: " + e.getMessage());
        }
    }

    public void sendDefaultMessage(EmailDTO emailDTO) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper( message, true, "UTF-8");
            helper.setFrom("no-reply@hotelbooking.com", "Hotel Booking");
            helper.setTo(emailDTO.getMail());
            helper.setSubject("Unknown purpose");
            helper.setText(emailDTO.getText());
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildEmailBody(BookingRoomResponse bookingResponse) {
        StringBuilder body = new StringBuilder();

        body.append("<h1>Thông tin đặt phòng của bạn</h1>");
        body.append("<p><strong>Khách sạn:</strong> ").append(bookingResponse.getHotel().getName()).append("</p>");
        body.append("<p><strong>Ngày check-in:</strong> ").append(bookingResponse.getCheckInDate()).append("</p>");
        body.append("<p><strong>Ngày check-out:</strong> ").append(bookingResponse.getCheckOutDate()).append("</p>");
        body.append("<p><strong>Người lớn:</strong> ").append(bookingResponse.getAdults()).append("</p>");
        body.append("<p><strong>Trẻ em:</strong> ").append(bookingResponse.getChildren()).append("</p>");
        body.append("<p><strong>Tổng tiền:</strong> ").append(bookingResponse.getTotalPrice()).append(" VND</p>");

        // Thêm bảng hiển thị thông tin phòng
        body.append("<h2>Chi tiết các phòng đã đặt:</h2>");
        body.append("<table border='1' cellpadding='10' cellspacing='0' style='border-collapse: collapse;'>");
        body.append("<tr>")
                .append("<th>Loại phòng</th>")
                .append("<th>Số lượng</th>")
                .append("<th>Giá thuê mỗi phòng</th>")
                .append("</tr>");

        // Duyệt qua danh sách các phòng đã đặt
        for (SeperatedRoomResponse room : bookingResponse.getRoomSelectionResponse().getSelectedRooms()) {
            body.append("<tr>")
                    .append("<td>").append(room.getType()).append("</td>")
                    .append("<td>").append(room.getCount()).append("</td>")
                    .append("<td>").append(room.getPrice()).append(" VND</td>")
                    .append("</tr>");
        }

        body.append("</table>");

        return body.toString();
    }


}
