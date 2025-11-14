

package com.psy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Головний клас програми для роботи з базою даних розкладу коледжу.
 * 
 * <p>Цей клас використовує ORM фреймворк Hibernate для взаємодії з базою даних. Він виконує дві основні операції:
 * <ul>
 *   <li>Перша транзакція: Додавання даних до таблиць Departments, Teachers, Students, Courses, Rooms, ClassSchedules та Enrollments.</li>
 *   <li>Друга транзакція: Виконання запиту для отримання інформації про розклад занять студентів.</li>
 * </ul>
 * </p>
 * 
 * <p>Клас використовує наступні Entity класи таблиць бази даних:
 * <ul>
 *   <li>{@link Psychologist}</li>
 *   <li>{@link Client}</li>
 *   <li>{@link Clinic}</li>
 *   <li>{@link Session}</li>
 * </ul>
 * </p>
 * 
 * <p>Запит у другій транзакції повертає об'єкти {@link InfoDTO}, які містять інформацію про студентів, викладачів, курси, кафедри, аудиторії, семестри, роки та час занять.</p>
 * 
 * <p>Для запуску програми необхідно мати налаштований файл конфігурації Hibernate (hibernate.cfg.xml).</p>
 * 
 * @see Psychologist
 * @see Clinic
 * @see Client
 * @see Session
 * @see InfoDTO
 */
public class MainApp {
    public static void main(String[] args) {
        // Створення фабрики сесій Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Psychologist.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Session.class)
                .addAnnotatedClass(Clinic.class)
                .buildSessionFactory();

        // Перша транзакція: Додавання даних 
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            Clinic clinic = new Clinic();
            clinic.setCity("Київ");
            clinic.setStreet("вул. Психології");
            clinic.setHouse("1");
            clinic.setPhoneNumber("380449940101");
            session.persist(clinic);

            Psychologist psy = new Psychologist();
            psy.setName("Олег Гнатюк");
            psy.setExperience(9);
            psy.setMeetingPlatform("Zoom");
            psy.setClinic(clinic);
            session.persist(psy);

            Client client = new Client();
            client.setFirstName("Антонюк");
            client.setLastName("Іван");
            client.setPrepayment("Basic");
            client.setpack("CBT");
            client.setSessionNumber(12);
            session.persist(client);

            PSession psySession = new PSession();
            psySession.setClient(client);
            psySession.setPsychologist(psy);
            psySession.setTopic("тривога");
            psySession.setDate(LocalDate.now());

                        // ---------- 2 ----------
            Client client2 = new Client();
            client2.setFirstName("Антонюк");
            client2.setLastName("Марія");
            client2.setPrepayment("Plus");
            client2.setpack("ACT");
            client2.setSessionNumber(8);
            session.persist(client2);

            PSession ps2 = new PSession();
            ps2.setClient(client2);
            ps2.setPsychologist(psy);
            ps2.setTopic("стрес");
            ps2.setDate(LocalDate.now());
            session.persist(ps2);


            // ---------- 3 ----------
            Client client3 = new Client();
            client3.setFirstName("Антонюк");
            client3.setLastName("Юлія");
            client3.setPrepayment("Student");
            client3.setpack("Psychoed");
            client3.setSessionNumber(4);
            session.persist(client3);

            PSession ps3 = new PSession();
            ps3.setClient(client3);
            ps3.setPsychologist(psy);
            ps3.setTopic("самооцінка");
            ps3.setDate(LocalDate.now());
            session.persist(ps3);


            // ---------- 4 ----------
            Clinic clinic2 = new Clinic();
            clinic2.setCity("Київ");
            clinic2.setStreet("просп. Гармонії");
            clinic2.setHouse("7");
            clinic2.setPhoneNumber("380449940202");
            session.persist(clinic2);

            Psychologist psy2 = new Psychologist();
            psy2.setName("Сергій Левченко");
            psy2.setExperience(12);
            psy2.setMeetingPlatform("Google Meet");
            psy2.setClinic(clinic2);
            session.persist(psy2);

            Client client4 = new Client();
            client4.setFirstName("Гриневич");
            client4.setLastName("Сергій");
            client4.setPrepayment("Family");
            client4.setpack("CBT");
            client4.setSessionNumber(10);
            session.persist(client4);

            PSession ps4 = new PSession();
            ps4.setClient(client4);
            ps4.setPsychologist(psy2);
            ps4.setTopic("прокрастинація");
            ps4.setDate(LocalDate.now());
            session.persist(ps4);


            // ---------- 5 ----------
            Psychologist psy3 = new Psychologist();
            psy3.setName("Олег Гнатюк");
            psy3.setExperience(12);
            psy3.setMeetingPlatform("Google Meet");
            psy3.setClinic(clinic2);
            session.persist(psy3);

            Client client5 = new Client();
            client5.setFirstName("Гриневич");
            client5.setLastName("Олег");
            client5.setPrepayment("Basic");
            client5.setpack("CBT");
            client5.setSessionNumber(10);
            session.persist(client5);

            PSession ps5 = new PSession();
            ps5.setClient(client5);
            ps5.setPsychologist(psy3);
            ps5.setTopic("тривога");
            ps5.setDate(LocalDate.now());
            session.persist(ps5);


            // ---------- 6 ----------
            Client client6 = new Client();
            client6.setFirstName("Гриневич");
            client6.setLastName("Олег");
            client6.setPrepayment("Basic");
            client6.setpack("ACT");
            client6.setSessionNumber(6);
            session.persist(client6);

            PSession ps6 = new PSession();
            ps6.setClient(client6);
            ps6.setPsychologist(psy3);
            ps6.setTopic("стрес");
            ps6.setDate(LocalDate.now());
            session.persist(ps6);


            // ---------- 7 ----------
            Clinic clinic3 = new Clinic();
            clinic3.setCity("Київ");
            clinic3.setStreet("вул. Рівноваги");
            clinic3.setHouse("10");
            clinic3.setPhoneNumber("380449940303");
            session.persist(clinic3);

            Psychologist psy4 = new Psychologist();
            psy4.setName("Марія Коваленко");
            psy4.setExperience(7);
            psy4.setMeetingPlatform("Zoom");
            psy4.setClinic(clinic3);
            session.persist(psy4);

            Client client7 = new Client();
            client7.setFirstName("Мороз");
            client7.setLastName("Марія");
            client7.setPrepayment("Plus");
            client7.setpack("CBT");
            client7.setSessionNumber(8);
            session.persist(client7);

            PSession ps7 = new PSession();
            ps7.setClient(client7);
            ps7.setPsychologist(psy4);
            ps7.setTopic("травм. досвід");
            ps7.setDate(LocalDate.now());
            session.persist(ps7);


            // ---------- 8 ----------
            Psychologist psy5 = new Psychologist();
            psy5.setName("Юлія Демчук");
            psy5.setExperience(7);
            psy5.setMeetingPlatform("Zoom");
            psy5.setClinic(clinic3);
            session.persist(psy5);

            Client client8 = new Client();
            client8.setFirstName("Мороз");
            client8.setLastName("Юлія");
            client8.setPrepayment("Student");
            client8.setpack("EMDR");
            client8.setSessionNumber(12);
            session.persist(client8);

            PSession ps8 = new PSession();
            ps8.setClient(client8);
            ps8.setPsychologist(psy5);
            ps8.setTopic("сон");
            ps8.setDate(LocalDate.now());
            session.persist(ps8);


            // ---------- 9 ----------
            Psychologist psy6 = new Psychologist();
            psy6.setName("Сергій Левченко");
            psy6.setExperience(7);
            psy6.setMeetingPlatform("Zoom");
            psy6.setClinic(clinic3);
            session.persist(psy6);

            Client client9 = new Client();
            client9.setFirstName("Мороз");
            client9.setLastName("Сергій");
            client9.setPrepayment("Family");
            client9.setpack("CBT");
            client9.setSessionNumber(6);
            session.persist(client9);

            PSession ps9 = new PSession();
            ps9.setClient(client9);
            ps9.setPsychologist(psy6);
            ps9.setTopic("самооцінка");
            ps9.setDate(LocalDate.now());
            session.persist(ps9);


            // ---------- 10 ----------
            Client client10 = new Client();
            client10.setFirstName("Антонюк");
            client10.setLastName("Олег");
            client10.setPrepayment("Basic");
            client10.setpack("Psychoed");
            client10.setSessionNumber(4);
            session.persist(client10);

            PSession ps10 = new PSession();
            ps10.setClient(client10);
            ps10.setPsychologist(psy);
            ps10.setTopic("стрес");
            ps10.setDate(LocalDate.now());
            session.persist(ps10);


            // ---------- 11 ----------
            Client client11 = new Client();
            client11.setFirstName("Гриневич");
            client11.setLastName("Сергій");
            client11.setPrepayment("Family");
            client11.setpack("ACT");
            client11.setSessionNumber(8);
            session.persist(client11);

            PSession ps11 = new PSession();
            ps11.setClient(client11);
            ps11.setPsychologist(psy2);
            ps11.setTopic("тривога");
            ps11.setDate(LocalDate.now());
            session.persist(ps11);


            // ---------- 12 ----------
            Client client12 = new Client();
            client12.setFirstName("Мороз");
            client12.setLastName("Юлія");
            client12.setPrepayment("Student");
            client12.setpack("CBT");
            client12.setSessionNumber(6);
            session.persist(client12);

            PSession ps12 = new PSession();
            ps12.setClient(client12);
            ps12.setPsychologist(psy5);
            ps12.setTopic("травм. досвід");
            ps12.setDate(LocalDate.now());
            session.persist(ps12);
            session.persist(psySession);
            session.getTransaction().commit();
            ;
                        
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Друга транзакція: Виконання запиту
        try (Session session = factory.openSession()) {
            // Початок транзакції
            session.beginTransaction();

            // Виконання запиту
            String hql = "SELECT new com.psy.InfoDTO(" +
                    "c.firstName, c.lastName, " +
                    "p.name, p.meetingPlatform, " +
                    "c.prepayment, " +
                    "CONCAT(c.pack, ' ', c.sessionNumber), " +
                    "s.topic," +
                    "p.experience,"+
                    "CONCAT(cl.city, ' ', cl.street, ' ', cl.house),"+
                    "cl.phoneNumber," +
                    "s.date) " +
                    "FROM PSession s " +
                    "JOIN s.client c " +
                    "JOIN s.psychologist p " +
                    "JOIN p.clinic cl ";


            List<InfoDTO> results = session.createQuery(hql, InfoDTO.class).getResultList();

            // Обробка результатів
            for (InfoDTO info : results) {
                System.out.println("Ім'я клієнта: " + info.getClientFirstName() + " " + info.getClientLastName());
                System.out.println("Фамілія психолога: " + info.getPsychologistName());
                System.out.println("Платформа відеозв'язку: " + info.getMeetingPlatform());
                System.out.println("Тип передплати: " + info.getPrepayment());
                System.out.println("Пакет сеансів: " + info.getpack());
                System.out.println("Тема сеансів: " + info.getTopic());
                System.out.println("Стаж психолога: " + info.getExperience());
                System.out.println("Адреса клініки: " + info.getClinicAdress());
                System.out.println("Телефон клініки: " + info.getClinicPhoneNumber());
                System.out.println("Дата зустрічі: " + info.getDate());
                System.out.println("--------------------------------------------------");
            }

            // Підтвердження транзакції
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}