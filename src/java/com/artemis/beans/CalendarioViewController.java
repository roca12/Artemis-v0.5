package com.artemis.beans;

import com.artemis.entities.Evento;
import com.artemis.service.EventoService;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean(name = "calendarioViewController")
@ViewScoped
public class CalendarioViewController implements Serializable {

    private ScheduleModel eventModel;
    private ScheduleModel lazyEventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    private boolean showWeekends = true;
    private boolean tooltip = true;
    private boolean allDaySlot = true;
    private String timeFormat;
    private String slotDuration = "00:30:00";
    private String slotLabelInterval;
    private String scrollTime = "06:00:00";
    private String minTime = "00:00:00";
    private String maxTime = "00:00:00";
    private String locale = "es";
    private String timeZone = "America/Bogota";
    private String clientTimeZone = "America/Bogota";
    private String columnHeaderFormat = "";

    //---- carga de eventos a calendario-----//
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();

        lazyEventModel = new LazyScheduleModel() {

            @Override
            public void loadEvents(LocalDateTime start, LocalDateTime end) {
                final String PERSISTENCE_UNIT_NAME = "ArtemiswarPU";
                final EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
                Query queryObj = entityMgrObj.createQuery("SELECT e FROM Evento e");
                List<Evento> list = queryObj.getResultList();
                list.stream()
                        .map((e) -> {
                            LocalDateTime inicio = ToLocalDateTime(e.getFechainicio());
                            LocalDateTime fin = ToLocalDateTime(e.getFechafinal());
                            DefaultScheduleEvent event = DefaultScheduleEvent.builder()
                                    .title(e.getTitulo())
                                    .startDate(inicio)
                                    .endDate(fin)
                                    .description(e.getDescripcion())
                                    .build();
                            return event;
                        }
                        ).forEachOrdered(
                                (event) -> {
                                    addEvent(event);
                                }
                        );
            }
        };
    }

    public LocalDateTime ToLocalDateTime(java.util.Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime())
                .atZone(ZoneId.of("UTC"))
                .toLocalDateTime();
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.of("UTC")).toInstant());
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleModel getLazyEventModel() {
        return lazyEventModel;
    }

    public LocalDate getInitialDate() {
        return LocalDate.now().plusDays(1);
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent() {
        if (event.isAllDay()) {
            if (event.getStartDate().toLocalDate().equals(event.getEndDate().toLocalDate())) {
                event.setEndDate(event.getEndDate().plusDays(1));
            }
        }

        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent<ScheduleEvent> selectEvent) {
        event = selectEvent.getObject();
    }

    public void onDateSelect(SelectEvent<LocalDateTime> selectEvent) {
        event = DefaultScheduleEvent.builder().startDate(selectEvent.getObject()).endDate(selectEvent.getObject().plusHours(1)).build();
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Delta:" + event.getDeltaAsDuration());
        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Start-Delta:" + event.getDeltaStartAsDuration() + ", End-Delta: " + event.getDeltaEndAsDuration());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public boolean isShowWeekends() {
        return showWeekends;
    }

    public void setShowWeekends(boolean showWeekends) {
        this.showWeekends = showWeekends;
    }

    public boolean isTooltip() {
        return tooltip;
    }

    public void setTooltip(boolean tooltip) {
        this.tooltip = tooltip;
    }

    public boolean isAllDaySlot() {
        return allDaySlot;
    }

    public void setAllDaySlot(boolean allDaySlot) {
        this.allDaySlot = allDaySlot;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(String slotDuration) {
        this.slotDuration = slotDuration;
    }

    public String getSlotLabelInterval() {
        return slotLabelInterval;
    }

    public void setSlotLabelInterval(String slotLabelInterval) {
        this.slotLabelInterval = slotLabelInterval;
    }

    public String getScrollTime() {
        return scrollTime;
    }

    public void setScrollTime(String scrollTime) {
        this.scrollTime = scrollTime;
    }

    public String getMinTime() {
        return minTime;
    }

    public void setMinTime(String minTime) {
        this.minTime = minTime;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getClientTimeZone() {
        return clientTimeZone;
    }

    public void setClientTimeZone(String clientTimeZone) {
        this.clientTimeZone = clientTimeZone;
    }

    public String getColumnHeaderFormat() {
        return columnHeaderFormat;
    }

    public void setColumnHeaderFormat(String columnHeaderFormat) {
        this.columnHeaderFormat = columnHeaderFormat;
    }
    //---- Crear eliminar actualizar evento----//
    private Integer idnew;
    private String titulonew;
    private Date fechaininew;
    private Date fechafinnew;
    private String descnew;
    private Evento eventoSeleccionado;

    private List<Evento> filteredEvento;
    EventoService eventoService = new EventoService();

    // _____________________________________________//
    public String crearEvento() {
        return eventoService.createNewEvento(null, titulonew, fechaininew, fechafinnew, descnew); 
    }

    public List<Evento> getEventoList() {
        return eventoService.getAllEvento();
    }

    public String deleteEventoById() {
        return eventoService.deleteEvento(eventoSeleccionado);
    }

    public String actualizarEvento() {
        Integer id2 = eventoSeleccionado.getId();
        String titulo = eventoSeleccionado.getTitulo();
        Date fechaini = eventoSeleccionado.getFechainicio();
        Date fechafin = eventoSeleccionado.getFechafinal();
        String desc = eventoSeleccionado.getDescripcion();
        return eventoService.updateEventoDetails(id2, titulo, fechaini, fechafin, desc);
    }

    public boolean filterByTitulo(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }
        Evento ev = (Evento) value;
        return ev.getTitulo().contains(filterText);
    }

//    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
//        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
//        if (filterText == null || filterText.equals("")) {
//            return true;
//        }
//
//        Evento ev = (Evento) value;
//        return ev.getId() < filterInt
//                || ev.getFecha().contains(filterText)
//                || ev.getSegundonombre().contains(filterText)
//                || ev.getPrimerapellido().contains(filterText)
//                || ev.getSegundoapellido().contains(filterText)
//                || ev.getUsername().contains(filterText)
//                || ev.getCorreo().contains(filterText);
//    }
    public Integer getIdnew() {
        return idnew;
    }

    public void setIdnew(Integer idnew) {
        this.idnew = idnew;
    }

    public String getTitulonew() {
        return titulonew;
    }

    public void setTitulonew(String titulonew) {
        this.titulonew = titulonew;
    }

    public Date getFechaininew() {
        return fechaininew;
    }

    public void setFechaininew(Date fechaininew) {
        this.fechaininew = fechaininew;
    }

    public Date getFechafinnew() {
        return fechafinnew;
    }

    public void setFechafinnew(Date fechafinnew) {
        this.fechafinnew = fechafinnew;
    }

    public String getDescnew() {
        return descnew;
    }

    public void setDescnew(String descnew) {
        this.descnew = descnew;
    }

    public Evento getEventoSeleccionado() {
        return eventoSeleccionado;
    }

    public void setEventoSeleccionado(Evento eventoSeleccionado) {
        this.eventoSeleccionado = eventoSeleccionado;
    }

    public List<Evento> getFilteredEvento() {
        return filteredEvento;
    }

    public void setFilteredEvento(List<Evento> filteredEvento) {
        this.filteredEvento = filteredEvento;
    }

    public EventoService getEventoService() {
        return eventoService;
    }

    public void setEventoService(EventoService eventoService) {
        this.eventoService = eventoService;
    }

}
